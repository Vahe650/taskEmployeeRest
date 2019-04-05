package com.taskemployeerest.rest.controller;

import com.taskemployeerest.rest.model.Task;
import com.taskemployeerest.rest.model.TaskStatus;
import com.taskemployeerest.rest.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class TaskEndpoint {
    private TaskRepository taskRepository;

    @GetMapping("/allTasks")
    public Flux<Task> allTask() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasksByEm/{employeeId}")
    public Flux<Task> allTaskByEmployer(@PathVariable(name = "employeeId") String id) {
        return taskRepository.findAllByEmployerId(id);
    }

    @GetMapping("/tasksByEmAndStat/{employeeId}")
    public Flux<Task> allTaskByEmployerAndStatus(@PathVariable(name = "employeeId") String id) {
        return taskRepository.findAllByEmployerIdAndStatusNotLike(id, TaskStatus.FINISHED);
    }

    @PutMapping("/inProgress/{taskId}")
    public Mono<Task> inprogresTask(@RequestBody Mono<Task> taskMono,
                                    @PathVariable(name = "taskId") String id) {
        return taskMono.flatMap(task -> {
            task.setId(id);
            if (task.getStatus().equals(TaskStatus.NEW)) {
                task.setStatus(TaskStatus.INPROGRESS);
            }
            return taskRepository.save(task);
        });
    }

    @PutMapping("finished/{taskId}")
    public Mono<Task> finishedTask(@RequestBody Mono<Task> taskMono,
                                   @PathVariable(name = "taskId") String id) {
        return taskMono.flatMap(task -> {
            task.setId(id);
            task.setStatus(TaskStatus.FINISHED);
            return taskRepository.save(task);
        });
    }

    @PostMapping("addTask/{employeeId}")
    public Mono<Task> addTask(@RequestBody Mono<Task> taskMono,
                              @PathVariable(name = "employeeId") String id) {
        return taskMono.flatMap(task -> {
            task.setEmployerId(id);
            return taskRepository.save(task);
        });
    }

    @GetMapping("/getOneTask/{id}")
    public Mono<Task> one(@PathVariable(name = "id") String id) {
        return taskRepository.findById(id);
    }

    @DeleteMapping("/deleteTask/{id}")
    public Mono<Void> deleteTask(@PathVariable(name = "id") String id) {
        return taskRepository.deleteById(id);
    }

    @PutMapping("/updateTask/{id}")
    public Mono<Task> updateTask(@RequestBody Mono<Task> taskMono,
                                 @PathVariable(name = "id") String id) {
        return taskMono.flatMap(task -> {
            task.setId(id);
            return taskRepository.save(task);
        });
    }
}