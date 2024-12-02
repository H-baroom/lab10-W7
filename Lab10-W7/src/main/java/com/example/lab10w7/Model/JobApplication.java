package com.example.lab10w7.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Positive(message = "not valid user id")
    @Column(columnDefinition = "int not null")
    private Integer userId;
    @Positive(message = "not valid user id")
    @Column(columnDefinition = "int not null")
    private Integer jobPostId;

}
