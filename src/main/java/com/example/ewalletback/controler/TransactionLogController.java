package com.example.ewalletback.controler;

import com.example.ewalletback.dto.request.TransactionLogRequestDto;
import com.example.ewalletback.models.Operation;
import com.example.ewalletback.services.implemantations.OperationServiceImpl;
import com.example.ewalletback.services.implemantations.TansactionLogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction-logs")
@RequiredArgsConstructor
public class TransactionLogController {

    private final TansactionLogServiceImpl transactionLogService;
    private final OperationServiceImpl operationService;

    @PostMapping
    public ResponseEntity<Void> enregistrer(@RequestBody TransactionLogRequestDto request) {
        Operation operation = operationService.findById(request.getOperationId());
        transactionLogService.enregistrer(operation);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
