package com.example.ewalletback.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private BigDecimal solde;

    private String devise;

    private LocalDateTime dateCreation;

    @Enumerated(EnumType.STRING)
    private StatutWallet statut;

    @OneToOne
    private Users user;

    @OneToMany(mappedBy = "wallet")
    private List<Operation> operations;

}
