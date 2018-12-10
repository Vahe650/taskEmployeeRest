package com.taskemployeerest.rest.repository;



import com.taskemployeerest.rest.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer,Integer> {

}
