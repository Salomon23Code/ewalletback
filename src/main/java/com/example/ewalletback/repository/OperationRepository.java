package com.example.ewalletback.repository;

import com.example.ewalletback.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByWalletId(Long walletId);
}
