package com.example.ewalletback.dto.request;

import com.example.ewalletback.models.StatutCompte;
import lombok.Data;

@Data
public class UserRequestDto {

    private String nom;
    private String email;
    private String phone;
    private StatutCompte statut;
}
