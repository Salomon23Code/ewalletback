package com.example.ewalletback.mapper;

import com.example.ewalletback.dto.response.OperationResponseDto;
import com.example.ewalletback.models.Operation;

public final class OperationMapper {

    private OperationMapper() {
    }

    public static OperationResponseDto toDto(Operation operation) {
        OperationResponseDto dto = new OperationResponseDto();
        dto.setId(operation.getId());
        dto.setType(operation.getClass().getSimpleName());
        dto.setReference(operation.getReference());
        dto.setMontant(operation.getMontant());
        dto.setFrais(operation.getFrais());
        dto.setDateOperation(operation.getDateOperation());
        dto.setStatut(operation.getStatut());
        dto.setDescription(operation.getDescription());
        if (operation.getWallet() != null) {
            dto.setWalletId(operation.getWallet().getId());
        }
        return dto;
    }
}
