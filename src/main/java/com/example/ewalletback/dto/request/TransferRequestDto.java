package com.example.ewalletback.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequestDto {

    private Long walletId;
    private Long walletDestinataireId;
    private BigDecimal montant;
    private String description;
    private String motif;
}
