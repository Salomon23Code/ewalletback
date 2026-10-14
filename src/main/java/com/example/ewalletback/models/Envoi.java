package com.example.ewalletback.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Envoi extends Operation {

    private String telephoneDestinataire;

    private String nomDestinataire;

    private String message;

}