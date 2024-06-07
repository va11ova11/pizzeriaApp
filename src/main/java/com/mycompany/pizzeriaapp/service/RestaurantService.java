package com.mycompany.pizzeriaapp.service;

import com.mycompany.pizzeriaapp.Util.CourierMapper;
import com.mycompany.pizzeriaapp.Util.WorkerMapper;
import com.mycompany.pizzeriaapp.dto.CourierDto;
import com.mycompany.pizzeriaapp.dto.RestaurantDto;
import com.mycompany.pizzeriaapp.dto.WorkerDto;
import com.mycompany.pizzeriaapp.entity.CourierEntity;
import com.mycompany.pizzeriaapp.entity.RestaurantEntity;
import com.mycompany.pizzeriaapp.entity.WorkerEntity;
import com.mycompany.pizzeriaapp.exception.NotFoundException;
import com.mycompany.pizzeriaapp.exception.ExistException;
import com.mycompany.pizzeriaapp.repository.CourierRepository;
import com.mycompany.pizzeriaapp.repository.RestaurantRepositories;
import com.mycompany.pizzeriaapp.repository.WorkerRepository;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mycompany.pizzeriaapp.Util.RestaurantMapper.mapToRestaurantDto;
import static com.mycompany.pizzeriaapp.Util.RestaurantMapper.mapToRestaurantEntity;

@Service
public class RestaurantService {

    private final RestaurantRepositories restaurantRepositories;
    private final WorkerRepository workerRepository;
    private final CourierRepository courierRepository;

    public RestaurantService(RestaurantRepositories restaurantRepositories, WorkerRepository workerRepository,
        CourierRepository courierRepository) {
        this.restaurantRepositories = restaurantRepositories;
        this.workerRepository = workerRepository;
        this.courierRepository = courierRepository;
    }


    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        RestaurantEntity savedRestaurant = restaurantRepositories.save(
            mapToRestaurantEntity(restaurantDto));
        return mapToRestaurantDto(savedRestaurant);
    }

    public RestaurantDto getRestaurantById(Long restaurantId) {
        RestaurantEntity restaurantEntity = getRestaurantByIdOrElseException(restaurantId);
        return mapToRestaurantDto(restaurantEntity);
    }

    public List<RestaurantDto> getAllRestaurant() {
        List<RestaurantDto> restaurant = new ArrayList<>();
        for(RestaurantEntity pe : restaurantRepositories.findAll()) {
            restaurant.add(mapToRestaurantDto(pe));
        }
        return restaurant;
    }


    public ResponseEntity<String> deleteRestaurantById(Long id) {
        if(restaurantRepositories.existsById(id)) {
            restaurantRepositories.deleteById(id);
            return new ResponseEntity<>(String.format("Ресторан с id -%s удалён", id), HttpStatus.OK);
        } else throw new NotFoundException(String.format("Ресторана с id - %s не существует", id));
    }

    public RestaurantDto addWorker(Long restaurantId, Long workerId) {

       if(restaurantRepositories.existsById(restaurantId)) {
           if (workerRepository.existsById(workerId)) {

               WorkerEntity workerEntity = workerRepository.findById(workerId).get();

               if (workerEntity.getRestaurantEntity() != null) {
                   throw new ExistException(
                       String.format("Работник уже находится в другом ресторане по адресу - %s",
                           workerEntity.getRestaurantEntity().getAddress()));
               }

               RestaurantEntity restaurantEntity = restaurantRepositories.findById(restaurantId).get();


               restaurantEntity.addWorker(workerEntity);
               return mapToRestaurantDto(restaurantRepositories.save(restaurantEntity));

           } else throw new NotFoundException("Работника с id - " + workerId + "не существует");
       } else throw new NotFoundException("Ресторана с id - " + restaurantId + "не существует");
    }

    public RestaurantDto addCourier(Long restaurantId, Long courierId) {

        RestaurantEntity restaurantEntity = getRestaurantByIdOrElseException(restaurantId);

        CourierEntity courierEntity = courierRepository.findById(courierId).
            orElseThrow(() -> new NotFoundException(
                String.format("Курьера с id - %s не существует", courierId)
            ));

        if (courierEntity.getRestaurantEntity() != null) {
            throw new ExistException(
                String.format("Курьер уже находится в другом ресторане по адресу -%s",
                    courierEntity.getRestaurantEntity().getAddress()));
        }

        restaurantEntity.addCourier(courierEntity);

        RestaurantEntity savedRestaurant = restaurantRepositories.save(restaurantEntity);
        return mapToRestaurantDto(savedRestaurant);
    }

    public RestaurantDto deleteWorker(Long restaurantId, Long workerId) {
        RestaurantEntity restaurantEntity = getRestaurantByIdOrElseException(restaurantId);
        WorkerEntity workerEntity = getWorkerByIdOrElseException(workerId);

        boolean workerContainsInRestaurant = restaurantEntity.getWorkerEntities().stream()
            .anyMatch(we -> we.getId().equals(workerId));

        if(workerContainsInRestaurant) {
            restaurantEntity.deleteWorker(workerEntity);
            RestaurantEntity savedRestaurant = restaurantRepositories.save(restaurantEntity);
            return mapToRestaurantDto(savedRestaurant);

        } else throw new NotFoundException("У ресторана нет такого работника");
    }

    public RestaurantDto deleteCourier(Long restaurantId, Long courierId) {
        RestaurantEntity restaurantEntity = getRestaurantByIdOrElseException(restaurantId);

        CourierEntity deleteCourier = restaurantEntity.getCourierEntities().stream()
            .filter(ce -> ce.getId().equals(courierId))
            .findFirst()
            .orElseThrow(() -> new NotFoundException(
            String.format("Курьера с id - %s не существует", courierId)
        ));

        restaurantEntity.deleteCourier(deleteCourier);
        RestaurantEntity savedRestaurant = restaurantRepositories.save(restaurantEntity);
        return mapToRestaurantDto(savedRestaurant);
    }

    public Set<WorkerDto> getWorkersByRestaurantId(Long restaurantId) {
        RestaurantEntity restaurantEntity = getRestaurantByIdOrElseException(restaurantId);

        return restaurantEntity.getWorkerEntities().stream().map(WorkerMapper::mapToWorkerDto)
            .collect(Collectors.toSet());

    }

    public Set<CourierDto> getCouriersByRestaurantId(Long restaurantId) {
        RestaurantEntity restaurantEntity = getRestaurantByIdOrElseException(restaurantId);

        return restaurantEntity.getCourierEntities().stream().map(CourierMapper::mapToCourierDto)
            .collect(Collectors.toSet());
    }

    private RestaurantEntity getRestaurantByIdOrElseException(Long restaurantId) {
        return restaurantRepositories.findById(restaurantId)
            .orElseThrow(() -> new NotFoundException(
                String.format("Ресторана с id - %s не существует", restaurantId)));
    }
    private WorkerEntity getWorkerByIdOrElseException(Long workerId) {
        return workerRepository.findById(workerId)
            .orElseThrow(() -> new NotFoundException(
                String.format("Работника с id - %s не существует", workerId)));

    }
}
