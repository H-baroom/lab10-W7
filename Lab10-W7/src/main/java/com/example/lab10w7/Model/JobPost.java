package com.example.lab10w7.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "not valid title")
    @Column(columnDefinition = "varchar(30) not null")
    private String title;
    @NotEmpty(message = "not valid description")
    @Column(columnDefinition = "varchar(1000) not null")
    private String description;
    @NotEmpty(message = "not valid location")
    private String location;
    @Positive(message = "not valid salary")
    private Integer salary;
    private LocalDate postingDate = LocalDate.now();
}
