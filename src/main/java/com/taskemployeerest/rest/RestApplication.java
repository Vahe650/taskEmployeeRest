package com.taskemployeerest.rest;

import com.taskemployeerest.rest.repository.EmployerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class RestApplication implements CommandLineRunner {

    private final EmployerRepository employerRepository;
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);

    }

    @Override
    public void run(String... args)  {
//        Employer employer = new Employer();
//        employer.setName("sdsd");
//        employerRepository.save(employer).block();
//        Employer empl = new Employer();
//        empl.setName("aaaa");
//        employerRepository.save(empl).block();
    }
}
