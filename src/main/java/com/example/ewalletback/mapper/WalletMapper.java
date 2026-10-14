package com.example.ewalletback.mapper;

import com.example.ewalletback.dto.request.WalletRequestDto;
import com.example.ewalletback.dto.response.WalletResponseDto;
import com.example.ewalletback.models.Users;
import com.example.ewalletback.models.Wallet;

public final class WalletMapper {

    private WalletMapper() {
    }

    public static Wallet toEntity(WalletRequestDto dto, Users user) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setDevise(dto.getDevise());
        wallet.setStatut(dto.getStatut());
        return wallet;
    }

    public static WalletResponseDto toDto(Wallet wallet) {
        WalletResponseDto dto = new WalletResponseDto();
        dto.setId(wallet.getId());
        dto.setNumero(wallet.getNumero());
        dto.setSolde(wallet.getSolde());
        dto.setDevise(wallet.getDevise());
        dto.setDateCreation(wallet.getDateCreation());
        dto.setStatut(wallet.getStatut());
        if (wallet.getUser() != null) {
            dto.setUserId(wallet.getUser().getId());
        }
        return dto;
    }
}
