package com.taskemployeerest.rest.repository;


import com.taskemployeerest.rest.model.Task;
import com.taskemployeerest.rest.model.TaskStatus;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface TaskRepository extends ReactiveMongoRepository<Task,String> {
    Flux<Task> findAllByEmployerId(String id);
    Flux<Task> findAllByEmployerIdAndStatusNotLike(String id, TaskStatus status);

}
