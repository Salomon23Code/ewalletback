package com.example.ewalletback.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionLogResponseDto {

    private Long id;
    private Long operationId;
    private BigDecimal ancienSolde;
    private BigDecimal nouveauSolde;
    private LocalDateTime dateLog;
    private String canal;
}
