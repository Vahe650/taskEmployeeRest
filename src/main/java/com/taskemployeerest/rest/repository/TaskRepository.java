package com.taskemployeerest.rest.repository;


import com.taskemployeerest.rest.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {

}
