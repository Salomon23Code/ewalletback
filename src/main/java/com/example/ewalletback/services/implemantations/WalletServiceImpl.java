package com.example.ewalletback.services.implemantations;

import com.example.ewalletback.models.Wallet;
import com.example.ewalletback.repository.WalletRepository;
import com.example.ewalletback.services.WalletService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    @Override
    public Wallet create(Wallet wallet) {

        wallet.setNumero(UUID.randomUUID().toString());
        wallet.setDateCreation(LocalDateTime.now());
        wallet.setSolde(BigDecimal.ZERO);

        return walletRepository.save(wallet);

    }

    @Override
    public Wallet findById(Long id) {

        return walletRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wallet introuvable"));

    }

    @Override
    public Wallet crediter(Long idWallet, BigDecimal montant) {

        Wallet wallet = findById(idWallet);

        wallet.setSolde(wallet.getSolde().add(montant));

        return walletRepository.save(wallet);

    }

    @Override
    public Wallet debiter(Long idWallet, BigDecimal montant) {

        Wallet wallet = findById(idWallet);

        if (wallet.getSolde().compareTo(montant) < 0)
            throw new RuntimeException("Solde insuffisant");

        wallet.setSolde(wallet.getSolde().subtract(montant));

        return walletRepository.save(wallet);

    }

    @Override
    public BigDecimal consulterSolde(Long idWallet) {

        return findById(idWallet).getSolde();

    }

}
