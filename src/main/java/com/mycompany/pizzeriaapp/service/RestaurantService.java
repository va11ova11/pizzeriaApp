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
import com.mycompany.pizzeriaapp.repository.CourierRepository;
import com.mycompany.pizzeriaapp.repository.RestaurantRepositories;
import com.mycompany.pizzeriaapp.repository.WorkerRepository;
import java.util.Set;
import java.util.stream.Collectors;
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
        RestaurantEntity newRestaurantEntity = mapToRestaurantEntity(restaurantDto);
        restaurantRepositories.save(newRestaurantEntity);
        return restaurantDto;
    }

    public RestaurantDto getRestaurantById(Long restaurantId) {
        RestaurantEntity restaurantEntity = getRestaurantByIdOrElseException(restaurantId);
        return mapToRestaurantDto(restaurantEntity);
    }

    public List<RestaurantDto> getAllRestaurant() {
        List<RestaurantDto> pizzerias = new ArrayList<>();
        for(RestaurantEntity pe : restaurantRepositories.findAll()) {
            pizzerias.add(mapToRestaurantDto(pe));
        }
        return pizzerias;
    }


    public Boolean deleteRestaurantById(Long id) {
        if(restaurantRepositories.existsById(id)) {
            restaurantRepositories.deleteById(id);
            return true;
        } else return false;
    }

    public RestaurantDto addWorker(Long restaurantId, Long workerId) {

       if(restaurantRepositories.existsById(restaurantId)) {
           if (workerRepository.existsById(workerId)) {

               RestaurantEntity restaurantEntity = restaurantRepositories.findById(restaurantId).get();
               WorkerEntity workerEntity = workerRepository.findById(workerId).get();

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

        restaurantEntity.addCourier(courierEntity);

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
        return restaurantRepositories.findById(restaurantId).
            orElseThrow(() -> new NotFoundException(
                String.format("Ресторана с id - %s не существует", restaurantId)));
    }
}
