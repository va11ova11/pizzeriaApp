package com.mycompany.pizzeriaapp.controller;

import com.mycompany.pizzeriaapp.dto.CourierDto;
import com.mycompany.pizzeriaapp.dto.RestaurantDto;
import com.mycompany.pizzeriaapp.dto.WorkerDto;
import com.mycompany.pizzeriaapp.service.RestaurantService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@Validated
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public RestaurantDto addRestaurant(@Valid @RequestBody RestaurantDto restaurantDto) {
        return restaurantService.addRestaurant(restaurantDto);
    }

    @GetMapping
    public List<RestaurantDto> getAllRestaurant() {
        return restaurantService.getAllRestaurant();
    }

    @GetMapping("/{id}")
    public RestaurantDto getRestaurantById(@PathVariable @NotNull Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurantById(@PathVariable @NotNull Long id) {
        return restaurantService.deleteRestaurantById(id);
    }

    @PostMapping("/workers")
    public RestaurantDto addWorker(@RequestParam @NotNull Long restaurantId,
                                   @RequestParam @NotNull Long workerId) {
        return restaurantService.addWorker(restaurantId, workerId);
    }

    @DeleteMapping("workers")
    public RestaurantDto deleteWorkerFromRestaurant(@RequestParam @NotNull Long restaurantId,
                                                              @RequestParam @NotNull Long workerId) {
        return restaurantService.deleteWorker(restaurantId, workerId);
    }

    @PostMapping("/couriers")
    public RestaurantDto addCourier(@RequestParam @NotNull Long restaurantId,
                                    @RequestParam @NotNull Long courierId) {
        return restaurantService.addCourier(restaurantId, courierId);
    }

    @DeleteMapping("/couriers")
    public RestaurantDto deleteCourier(@RequestParam @NotNull Long restaurantId,
                                    @RequestParam @NotNull Long courierId) {
        return restaurantService.deleteCourier(restaurantId, courierId);
    }


    @GetMapping("/{id}/workers")
    public Set<WorkerDto> getWorkersByRestaurantId(@PathVariable(name = "id") @NotNull Long restaurantId) {
        return restaurantService.getWorkersByRestaurantId(restaurantId);
    }

    @GetMapping("/{id}/couriers")
    public Set<CourierDto> getCouriersByRestaurantId(@PathVariable(name = "id") @NotNull Long restaurantId) {
        return restaurantService.getCouriersByRestaurantId(restaurantId);
    }
}
