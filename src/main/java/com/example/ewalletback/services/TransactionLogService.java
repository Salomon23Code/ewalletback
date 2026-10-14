package com.example.ewalletback.services;

import com.example.ewalletback.models.Operation;

public interface TransactionLogService {

    void enregistrer(Operation operation);

}
