package com.taskemployeerest.rest.repository;


import com.taskemployeerest.rest.model.Employer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends ReactiveMongoRepository<Employer,String> {

}
