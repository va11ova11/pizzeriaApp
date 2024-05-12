package com.mycompany.pizzeriaapp.controller;

import com.mycompany.pizzeriaapp.dto.RestaurantDto;
import com.mycompany.pizzeriaapp.dto.WorkerDto;
import com.mycompany.pizzeriaapp.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public RestaurantDto addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return restaurantService.addRestaurant(restaurantDto);
    }

    @GetMapping
    public List<RestaurantDto> getAllRestaurant() {
        return restaurantService.getAllRestaurant();
    }

    @GetMapping("/{id}")
    public RestaurantDto getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteRestaurantById(@PathVariable Long id) {
        return restaurantService.deleteRestaurantById(id);
    }

    @PostMapping("/add")
    public RestaurantDto addWorker(@RequestParam Long restaurantId,
                            @RequestParam Long workerId) {
        return restaurantService.addWorker(restaurantId, workerId);
    }
}
