package com.example.ewalletback.services.implemantations;

import com.example.ewalletback.models.Envoi;
import com.example.ewalletback.models.StatutOperation;
import com.example.ewalletback.repository.EnvoiRepository;
import com.example.ewalletback.services.EnvoiService;
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
public class EnvoiServiceImpl implements EnvoiService {

    private final WalletService walletService;
    private final EnvoiRepository repository;
    private final TransactionLogService logService;

    @Override
    public Envoi envoyer(Envoi envoi) {

        BigDecimal frais = new BigDecimal("500");

        envoi.setFrais(frais);

        walletService.debiter(
                envoi.getWallet().getId(),
                envoi.getMontant().add(frais));

        envoi.setDateOperation(LocalDateTime.now());
        envoi.setStatut(StatutOperation.REUSSIE);

        Envoi saved = repository.save(envoi);

        logService.enregistrer(saved);

        return saved;

    }

}