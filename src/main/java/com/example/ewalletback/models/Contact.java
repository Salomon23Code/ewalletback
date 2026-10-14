package com.example.ewalletback.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String telephone;

    @ManyToOne
    private Users user;

}