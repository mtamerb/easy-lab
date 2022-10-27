package com.tamerb.easylab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;


@Getter
@Setter
@Entity
@Table(name = "laborant")
public class Laborant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 50)
    private String name;

    @Size(max = 50)
    @NotEmpty
    private String surname;


    @NotNull
    @Column(unique = true)
    @Size(min = 7, max = 7, message
            = "Hospital ID must be 7 characters")
    private String hospitalID;

    public Laborant() {
    }

    public Laborant(String name, String surname, String hospitalID) {
        this.name = name;
        this.surname = surname;
        this.hospitalID = hospitalID;
    }

}
