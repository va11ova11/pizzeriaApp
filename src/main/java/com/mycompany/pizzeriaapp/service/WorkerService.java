package com.mycompany.pizzeriaapp.service;

import com.mycompany.pizzeriaapp.dto.WorkerDto;
import com.mycompany.pizzeriaapp.entity.WorkerEntity;
import com.mycompany.pizzeriaapp.exception.NotFoundException;
import com.mycompany.pizzeriaapp.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static com.mycompany.pizzeriaapp.Util.WorkerMapper.mapToWorkerDto;
import static com.mycompany.pizzeriaapp.Util.WorkerMapper.mapToWorkerEntity;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }


    public WorkerDto addWorker(WorkerDto workerDto) {
        WorkerEntity workerEntity = mapToWorkerEntity(workerDto);
        workerRepository.save(workerEntity);
        return workerDto;
    }


    public List<WorkerDto> getAllWorkers() {
        List<WorkerDto> workers = new ArrayList<>();
        for (WorkerEntity we : workerRepository.findAll()) {
            workers.add(mapToWorkerDto(we));
        }
        return workers;
    }

    public WorkerDto getWorkerById(Long id) {
        if (workerRepository.existsById(id)) {
            return mapToWorkerDto(workerRepository.findById(id).get());
        } else throw new NotFoundException(String.format("Работника с id - %s не существует", id));
    }

    public Boolean deleteWorkerById(Long id) {
        if (workerRepository.existsById(id)) {
            workerRepository.deleteById(id);
            return true;
        } else return false;
    }

    public WorkerDto getWorkerByNameAndSurname(String name, String surname) {
        if(workerRepository.existsByNameAndSurname(name, surname)) {
           return mapToWorkerDto(workerRepository.getWorkerEntitiesByNameAndSurname(name, surname));
        } else throw new NotFoundException(String.format(
                "Работника с именем %s и фвмилией %s не существует", name, surname));
    }
}
