package com.example.ewalletback.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Transfer extends Operation {

    @ManyToOne
    private Wallet walletDestinataire;

    private String motif;

}
