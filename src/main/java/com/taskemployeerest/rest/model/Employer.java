package com.taskemployeerest.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employer")
public class Employer {

    @Id
    private String id;
    private String name;
    private String surname;
    private Degree degree;


}
