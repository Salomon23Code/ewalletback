package com.example.ewalletback.mapper;

import com.example.ewalletback.dto.request.TransferRequestDto;
import com.example.ewalletback.dto.response.TransferResponseDto;
import com.example.ewalletback.models.Transfer;
import com.example.ewalletback.models.Wallet;

public final class TransferMapper {

    private TransferMapper() {
    }

    public static Transfer toEntity(TransferRequestDto dto, Wallet walletSource, Wallet walletDestinataire) {
        Transfer transfer = new Transfer();
        transfer.setWallet(walletSource);
        transfer.setWalletDestinataire(walletDestinataire);
        transfer.setMontant(dto.getMontant());
        transfer.setDescription(dto.getDescription());
        transfer.setMotif(dto.getMotif());
        return transfer;
    }

    public static TransferResponseDto toDto(Transfer transfer) {
        TransferResponseDto dto = new TransferResponseDto();
        dto.setId(transfer.getId());
        dto.setReference(transfer.getReference());
        dto.setMontant(transfer.getMontant());
        dto.setFrais(transfer.getFrais());
        dto.setDateOperation(transfer.getDateOperation());
        dto.setStatut(transfer.getStatut());
        dto.setDescription(transfer.getDescription());
        if (transfer.getWallet() != null) {
            dto.setWalletId(transfer.getWallet().getId());
        }
        if (transfer.getWalletDestinataire() != null) {
            dto.setWalletDestinataireId(transfer.getWalletDestinataire().getId());
        }
        dto.setMotif(transfer.getMotif());
        return dto;
    }
}
