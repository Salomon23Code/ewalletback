package com.example.ewalletback.services;

import com.example.ewalletback.models.Wallet;

import java.math.BigDecimal;

public interface WalletService {

    Wallet create(Wallet wallet);

    Wallet findById(Long id);

    Wallet crediter(Long idWallet, BigDecimal montant);

    Wallet debiter(Long idWallet, BigDecimal montant);

    BigDecimal consulterSolde(Long idWallet);

}
