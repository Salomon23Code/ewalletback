package com.example.ewalletback.dto.request;

import com.example.ewalletback.models.StatutWallet;
import lombok.Data;

@Data
public class WalletRequestDto {

    private Long userId;
    private String devise;
    private StatutWallet statut;
}
