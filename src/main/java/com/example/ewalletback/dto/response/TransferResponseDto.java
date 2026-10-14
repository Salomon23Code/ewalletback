package com.example.ewalletback.dto.response;

import com.example.ewalletback.models.StatutOperation;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransferResponseDto {

    private Long id;
    private String reference;
    private BigDecimal montant;
    private BigDecimal frais;
    private LocalDateTime dateOperation;
    private StatutOperation statut;
    private String description;
    private Long walletId;
    private Long walletDestinataireId;
    private String motif;
}
