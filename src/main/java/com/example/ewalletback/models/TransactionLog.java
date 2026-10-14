package com.example.ewalletback.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class TransactionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Operation operation;

    private BigDecimal ancienSolde;

    private BigDecimal nouveauSolde;

    private LocalDateTime dateLog;

    private String canal;

}