package com.example.ewalletback.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;

    private BigDecimal montant;

    private BigDecimal frais;

    private LocalDateTime dateOperation;

    @Enumerated(EnumType.STRING)
    private StatutOperation statut;

    private String description;

    @ManyToOne
    private Wallet wallet;

}