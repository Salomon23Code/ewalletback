package com.example.ewalletback.services.implemantations;

import com.example.ewalletback.models.Achat;
import com.example.ewalletback.models.StatutOperation;
import com.example.ewalletback.repository.AchatRepository;
import com.example.ewalletback.services.AchatService;
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
public class AchatServiceImpl implements AchatService {

    private final AchatRepository achatRepository;
    private final WalletService walletService;
    private final TransactionLogService logService;

    @Override
    public Achat effectuerAchat(Achat achat) {

        BigDecimal frais = achat.getMontant()
                .multiply(new BigDecimal("0.02"));

        achat.setFrais(frais);

        walletService.debiter(
                achat.getWallet().getId(),
                achat.getMontant().add(frais));

        achat.setDateOperation(LocalDateTime.now());
        achat.setStatut(StatutOperation.REUSSIE);

        Achat saved = achatRepository.save(achat);

        logService.enregistrer(saved);

        return saved;

    }

}
