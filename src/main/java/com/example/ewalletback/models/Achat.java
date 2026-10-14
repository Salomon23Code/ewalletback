package com.example.ewalletback.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Achat extends Operation {

    private Long idCommerce;

    private String nomCommerce;

    private String categorie;

    private String referenceCommande;

}
