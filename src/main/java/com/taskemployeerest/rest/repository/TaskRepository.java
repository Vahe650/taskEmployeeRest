package com.taskemployeerest.rest.repository;


import com.taskemployeerest.rest.model.Task;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TaskRepository extends ReactiveMongoRepository<Task,String> {

}
