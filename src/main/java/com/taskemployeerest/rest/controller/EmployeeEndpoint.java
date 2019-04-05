package com.taskemployeerest.rest.controller;

import com.taskemployeerest.rest.model.Employer;
import com.taskemployeerest.rest.repository.EmployerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class EmployeeEndpoint {
    private EmployerRepository employerRepository;


    @GetMapping("/all")
    public Flux<Employer> allElmployees() {
        return employerRepository.findAll();
    }

    @GetMapping("/getOneEmploYee/{id}")
    public Mono<Employer> one(@PathVariable(name = "id") String id) {
        return employerRepository.findById(id);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public Mono<Void> deleteUser(@PathVariable(name = "id") String id) {
        return employerRepository.deleteById(id);
    }

    @PostMapping("/saveEmployee")
    public Mono<Employer> saveEmployee(@RequestBody Mono<Employer> monoEmployer) {
        return monoEmployer.flatMap(employer -> employerRepository.save(employer));

    }


    @PutMapping("/updateEmployee/{id}")
    public Mono<Employer> updateEmployee(@RequestBody Mono<Employer> monoEmployer, @PathVariable("id") String id) {
        return monoEmployer.flatMap(employer -> {
            employer.setId(id);
            return   employerRepository.save(employer);
        });

    }
}
