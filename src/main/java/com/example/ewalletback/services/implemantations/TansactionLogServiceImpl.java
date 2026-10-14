package com.example.ewalletback.services.implemantations;

import com.example.ewalletback.models.Operation;
import com.example.ewalletback.models.TransactionLog;
import com.example.ewalletback.repository.TransactionLogRepository;
import com.example.ewalletback.services.TransactionLogService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class TansactionLogServiceImpl implements TransactionLogService {

    private final TransactionLogRepository repository;

    @Override
    public void enregistrer(Operation operation) {

        TransactionLog log = new TransactionLog();

        log.setOperation(operation);
        log.setDateLog(LocalDateTime.now());
        log.setCanal("API");
        log.setNouveauSolde(operation.getWallet().getSolde());

        repository.save(log);

    }

}