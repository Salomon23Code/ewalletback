package com.example.ewalletback.mapper;

import com.example.ewalletback.dto.request.EnvoiRequestDto;
import com.example.ewalletback.dto.response.EnvoiResponseDto;
import com.example.ewalletback.models.Envoi;
import com.example.ewalletback.models.Wallet;

public final class EnvoiMapper {

    private EnvoiMapper() {
    }

    public static Envoi toEntity(EnvoiRequestDto dto, Wallet wallet) {
        Envoi envoi = new Envoi();
        envoi.setWallet(wallet);
        envoi.setMontant(dto.getMontant());
        envoi.setDescription(dto.getDescription());
        envoi.setTelephoneDestinataire(dto.getTelephoneDestinataire());
        envoi.setNomDestinataire(dto.getNomDestinataire());
        envoi.setMessage(dto.getMessage());
        return envoi;
    }

    public static EnvoiResponseDto toDto(Envoi envoi) {
        EnvoiResponseDto dto = new EnvoiResponseDto();
        dto.setId(envoi.getId());
        dto.setReference(envoi.getReference());
        dto.setMontant(envoi.getMontant());
        dto.setFrais(envoi.getFrais());
        dto.setDateOperation(envoi.getDateOperation());
        dto.setStatut(envoi.getStatut());
        dto.setDescription(envoi.getDescription());
        if (envoi.getWallet() != null) {
            dto.setWalletId(envoi.getWallet().getId());
        }
        dto.setTelephoneDestinataire(envoi.getTelephoneDestinataire());
        dto.setNomDestinataire(envoi.getNomDestinataire());
        dto.setMessage(envoi.getMessage());
        return dto;
    }
}
