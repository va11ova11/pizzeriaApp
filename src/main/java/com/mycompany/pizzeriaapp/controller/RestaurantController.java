package com.mycompany.pizzeriaapp.controller;

import com.mycompany.pizzeriaapp.dto.CourierDto;
import com.mycompany.pizzeriaapp.dto.RestaurantDto;
import com.mycompany.pizzeriaapp.dto.WorkerDto;
import com.mycompany.pizzeriaapp.service.RestaurantService;
import java.util.Set;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
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

    @PostMapping("/addWorker")
    public RestaurantDto addWorker(@RequestParam Long restaurantId,
                            @RequestParam Long workerId) {
        return restaurantService.addWorker(restaurantId, workerId);
    }

    @PostMapping("/addCourier")
    public RestaurantDto addCourier(@RequestParam Long restaurantId,
                                    @RequestParam Long courierId) {
        return restaurantService.addCourier(restaurantId, courierId);
    }


    @GetMapping("/{id}/workers")
    public Set<WorkerDto> getWorkersByRestaurantId(@PathVariable(name = "id") Long restaurantId) {
        return restaurantService.getWorkersByRestaurantId(restaurantId);
    }

    @GetMapping("/{id}/couriers")
    public Set<CourierDto> getCouriersByRestaurantId(@PathVariable(name = "id") Long restaurantId) {
        return restaurantService.getCouriersByRestaurantId(restaurantId);
    }

}
