package com.example.ewalletback.services;

import com.example.ewalletback.models.Operation;

import java.util.List;

public interface OperationService {

    List<Operation> findAll();

    Operation findById(Long id);

    List<Operation> historique(Long walletId);

}