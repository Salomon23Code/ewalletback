package com.example.ewalletback.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EnvoiRequestDto {

    private Long walletId;
    private BigDecimal montant;
    private String description;
    private String telephoneDestinataire;
    private String nomDestinataire;
    private String message;
}
