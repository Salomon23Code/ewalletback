package com.example.ewalletback.dto.response;

import com.example.ewalletback.models.StatutCompte;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDto {

    private Long id;
    private String nom;
    private String email;
    private String phone;
    private LocalDateTime dateinscription;
    private StatutCompte statut;
    private Long walletId;
}
