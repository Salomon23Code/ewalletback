package com.example.ewalletback.services.implemantations;

import com.example.ewalletback.models.Operation;
import com.example.ewalletback.repository.OperationRepository;
import com.example.ewalletback.services.OperationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;

    @Override
    public List<Operation> findAll() {
        return operationRepository.findAll();
    }

    @Override
    public Operation findById(Long id) {

        return operationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Operation introuvable"));

    }

    @Override
    public List<Operation> historique(Long walletId) {

        return operationRepository.findByWalletId(walletId);

    }

}