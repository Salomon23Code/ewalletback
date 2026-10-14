package com.example.ewalletback.mapper;

import com.example.ewalletback.dto.response.TransactionLogResponseDto;
import com.example.ewalletback.models.TransactionLog;

public final class TransactionLogMapper {

    private TransactionLogMapper() {
    }

    public static TransactionLogResponseDto toDto(TransactionLog log) {
        TransactionLogResponseDto dto = new TransactionLogResponseDto();
        dto.setId(log.getId());
        if (log.getOperation() != null) {
            dto.setOperationId(log.getOperation().getId());
        }
        dto.setAncienSolde(log.getAncienSolde());
        dto.setNouveauSolde(log.getNouveauSolde());
        dto.setDateLog(log.getDateLog());
        dto.setCanal(log.getCanal());
        return dto;
    }
}
