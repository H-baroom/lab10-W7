package com.example.lab10w7.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "not valid name")
    @Size(min = 5,message = "name must contain at least 5 characters")
    @Pattern(
            regexp = "^[a-zA-Z ]+$",
            message = "Name must contain only characters (no numbers)."
    )
    @Column(columnDefinition = "varchar(35) not null")

    private String name;
    @Email(message = "not valid email")
    @Column(columnDefinition = "varchar(35) not null unique")
    private String email;
    @NotEmpty(message = "not valid password")
    private String password;
    @Positive(message = "age must be a number")
    @Min( value = 22, message = "age must be more then 21")
    @Column(columnDefinition = "varchar(40) not null")
    private Integer age;
    @NotEmpty(message = "not valid role")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)",message = "your role must be JOB_SEEKER or EMPLOYER")
    @Column(columnDefinition = "varchar(11) not null")
    private String role;
}
