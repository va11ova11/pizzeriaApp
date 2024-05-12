package com.mycompany.pizzeriaapp.service;

import com.mycompany.pizzeriaapp.dto.RestaurantDto;
import com.mycompany.pizzeriaapp.entity.RestaurantEntity;
import com.mycompany.pizzeriaapp.entity.WorkerEntity;
import com.mycompany.pizzeriaapp.exception.NotFoundException;
import com.mycompany.pizzeriaapp.repository.RestaurantRepositories;
import com.mycompany.pizzeriaapp.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mycompany.pizzeriaapp.Util.dtoMaker.makeRestaurantDto;
import static com.mycompany.pizzeriaapp.Util.dtoMaker.makeRestaurantEntity;

@Service
public class RestaurantService {

    private final RestaurantRepositories restaurantRepositories;
    private final WorkerRepository workerRepository;

    public RestaurantService(RestaurantRepositories restaurantRepositories, WorkerRepository workerRepository) {
        this.restaurantRepositories = restaurantRepositories;
        this.workerRepository = workerRepository;
    }


    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        RestaurantEntity newRestaurantEntity = makeRestaurantEntity(restaurantDto);
        restaurantRepositories.save(newRestaurantEntity);
        return restaurantDto;
    }

    public List<RestaurantDto> getAllRestaurant() {
        List<RestaurantDto> pizzerias = new ArrayList<>();
        for(RestaurantEntity pe : restaurantRepositories.findAll()) {
            pizzerias.add(makeRestaurantDto(pe));
        }
        return pizzerias;
    }

    public RestaurantDto getRestaurantById(Long id) {
        if(restaurantRepositories.existsById(id)) {
            return makeRestaurantDto(restaurantRepositories.findById(id).get());
        } else throw new NotFoundException("Такой пиццерии не существует");
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
               return makeRestaurantDto(restaurantRepositories.save(restaurantEntity));

           } else throw new NotFoundException("Работника с id - " + workerId + "не существует");
       } else throw new NotFoundException("Ресторана с id - " + restaurantId + "не существует");
    }
}
