package com.mycompany.pizzeriaapp.controller;

import com.mycompany.pizzeriaapp.dto.WorkerDto;
import com.mycompany.pizzeriaapp.service.workers.WorkerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }
    @PostMapping
    public WorkerDto addWorker(@Valid @RequestBody WorkerDto workerDto) {
        return workerService.addWorker(workerDto);
    }

    @GetMapping
    public List<WorkerDto> getAllWorkers() {
        return workerService.getAllWorkers();
    }

    @GetMapping("/{id}")
    public WorkerDto getWorkerById(@PathVariable Long id) {
        return workerService.getWorkerById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkerById(@PathVariable Long id) {
        return workerService.deleteWorkerById(id);
    }

    @GetMapping("/search")
    public WorkerDto getWorkerByNameAndSurname(@RequestParam String name,
                                               @RequestParam String surname) {
       return workerService.getWorkerByNameAndSurname(name, surname);
    }
}
