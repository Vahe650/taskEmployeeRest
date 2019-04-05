package com.taskemployeerest.rest.repository;


import com.taskemployeerest.rest.model.Degree;
import com.taskemployeerest.rest.model.Employer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployerRepository extends ReactiveMongoRepository<Employer,String> {

    Flux<Employer> findAllByDegreeNotLike(Degree degree);
}
