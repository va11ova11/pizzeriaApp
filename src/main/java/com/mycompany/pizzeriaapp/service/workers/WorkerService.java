package com.mycompany.pizzeriaapp.service.workers;
import com.mycompany.pizzeriaapp.Util.WorkerMapper;
import com.mycompany.pizzeriaapp.dto.WorkerDto;
import com.mycompany.pizzeriaapp.entity.WorkerEntity;
import com.mycompany.pizzeriaapp.exception.NotFoundException;
import com.mycompany.pizzeriaapp.repository.WorkerRepository;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
        WorkerEntity savedWorker = workerRepository.save(mapToWorkerEntity(workerDto));
        return mapToWorkerDto(savedWorker);
    }


    public List<WorkerDto> getAllWorkers() {
        return workerRepository.findAll().stream()
            .map(WorkerMapper::mapToWorkerDto)
            .collect(Collectors.toList());
    }

    public WorkerDto getWorkerById(Long id) {
        WorkerEntity workerEntity = workerRepository.findById(id).orElseThrow(
            () -> new NotFoundException(String.format("Работника с id - %s не существует", id)));
        return mapToWorkerDto(workerEntity);
    }

    public ResponseEntity<String> deleteWorkerById(Long id) {
        if (workerRepository.existsById(id)) {
            workerRepository.deleteById(id);
            return new ResponseEntity<>(String.format("Работник с id - %s удалён", id),
                HttpStatus.OK);
        } else {
            throw new NotFoundException(
                String.format("Удаляемого работника с id -%s не существует", id));
        }
    }

    public WorkerDto getWorkerByNameAndSurname(String name, String surname) {
        if (workerRepository.existsByNameAndSurname(name, surname)) {
            WorkerEntity workerEntity = workerRepository.getWorkerEntitiesByNameAndSurname(name,
                surname);
            return mapToWorkerDto(workerEntity);
        } else {
            throw new NotFoundException(String.format(
                "Работника с именем %s и фамилией %s не существует", name, surname));
        }
    }
}
