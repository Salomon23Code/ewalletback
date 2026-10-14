package com.example.ewalletback.services.implemantations;

import com.example.ewalletback.models.StatutOperation;
import com.example.ewalletback.models.Transfer;
import com.example.ewalletback.repository.TransferRepository;
import com.example.ewalletback.services.TranferServices;
import com.example.ewalletback.services.TransactionLogService;
import com.example.ewalletback.services.WalletService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class TransferServiceImpl implements TranferServices.TransfertService {

    private final WalletService walletService;
    private final TransferRepository repository;
    private final TransactionLogService logService;

    @Override
    public Transfer effectuerTransfert(Transfer transfert) {

        BigDecimal frais = transfert.getMontant()
                .multiply(new BigDecimal("0.01"));

        transfert.setFrais(frais);

        walletService.debiter(
                transfert.getWallet().getId(),
                transfert.getMontant().add(frais));

        walletService.crediter(
                transfert.getWalletDestinataire().getId(),
                transfert.getMontant());

        transfert.setDateOperation(LocalDateTime.now());
        transfert.setStatut(StatutOperation.REUSSIE);

        Transfer saved = repository.save(transfert);

        logService.enregistrer(saved);

        return saved;

    }

}