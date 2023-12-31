package com.momentum.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Investor {
    @Id
    private Integer id;
    private String name;
    private String surname;
    private String date_of_birth;
    private String cell_number;
    private String email;
    private String address_id;
}
