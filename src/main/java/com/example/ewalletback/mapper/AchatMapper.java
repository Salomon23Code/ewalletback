package com.example.ewalletback.mapper;

import com.example.ewalletback.dto.request.AchatRequestDto;
import com.example.ewalletback.dto.response.AchatResponseDto;
import com.example.ewalletback.models.Achat;
import com.example.ewalletback.models.Wallet;

public final class AchatMapper {

    private AchatMapper() {
    }

    public static Achat toEntity(AchatRequestDto dto, Wallet wallet) {
        Achat achat = new Achat();
        achat.setWallet(wallet);
        achat.setMontant(dto.getMontant());
        achat.setDescription(dto.getDescription());
        achat.setIdCommerce(dto.getIdCommerce());
        achat.setNomCommerce(dto.getNomCommerce());
        achat.setCategorie(dto.getCategorie());
        achat.setReferenceCommande(dto.getReferenceCommande());
        return achat;
    }

    public static AchatResponseDto toDto(Achat achat) {
        AchatResponseDto dto = new AchatResponseDto();
        dto.setId(achat.getId());
        dto.setReference(achat.getReference());
        dto.setMontant(achat.getMontant());
        dto.setFrais(achat.getFrais());
        dto.setDateOperation(achat.getDateOperation());
        dto.setStatut(achat.getStatut());
        dto.setDescription(achat.getDescription());
        if (achat.getWallet() != null) {
            dto.setWalletId(achat.getWallet().getId());
        }
        dto.setIdCommerce(achat.getIdCommerce());
        dto.setNomCommerce(achat.getNomCommerce());
        dto.setCategorie(achat.getCategorie());
        dto.setReferenceCommande(achat.getReferenceCommande());
        return dto;
    }
}
