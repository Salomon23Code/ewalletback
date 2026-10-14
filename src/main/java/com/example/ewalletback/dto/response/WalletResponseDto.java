package com.example.ewalletback.dto.response;

import com.example.ewalletback.models.StatutWallet;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class WalletResponseDto {

    private Long id;
    private String numero;
    private BigDecimal solde;
    private String devise;
    private LocalDateTime dateCreation;
    private StatutWallet statut;
    private Long userId;
}
