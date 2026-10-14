package com.example.ewalletback.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AchatRequestDto {

    private Long walletId;
    private BigDecimal montant;
    private String description;
    private Long idCommerce;
    private String nomCommerce;
    private String categorie;
    private String referenceCommande;
}
