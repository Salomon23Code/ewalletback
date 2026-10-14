package com.example.ewalletback.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Column(unique = true)
    private String email;
    private String phone;
    private LocalDateTime dateinscription;
    @Enumerated(EnumType.STRING)
    private StatutCompte statut;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Wallet wallet;

}
