package com.example.ewalletback.controler;

import com.example.ewalletback.dto.request.MontantRequestDto;
import com.example.ewalletback.dto.request.WalletRequestDto;
import com.example.ewalletback.dto.response.WalletResponseDto;
import com.example.ewalletback.mapper.WalletMapper;
import com.example.ewalletback.models.Users;
import com.example.ewalletback.models.Wallet;
import com.example.ewalletback.services.implemantations.UserServiceImpl;
import com.example.ewalletback.services.implemantations.WalletServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletServiceImpl walletService;
    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<WalletResponseDto> createWallet(@RequestBody WalletRequestDto request) {
        Users user = userService.findById(request.getUserId());
        Wallet wallet = walletService.create(WalletMapper.toEntity(request, user));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(WalletMapper.toDto(wallet));
    }

    @GetMapping("/{walletId}/solde")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable Long walletId) {
        return ResponseEntity.ok(walletService.consulterSolde(walletId));
    }

    @PostMapping("/{walletId}/crediter")
    public ResponseEntity<WalletResponseDto> crediter(
            @PathVariable Long walletId,
            @RequestBody MontantRequestDto request) {

        Wallet wallet = walletService.crediter(walletId, request.getMontant());
        return ResponseEntity.ok(WalletMapper.toDto(wallet));
    }

    @PostMapping("/{walletId}/debiter")
    public ResponseEntity<WalletResponseDto> debiter(
            @PathVariable Long walletId,
            @RequestBody MontantRequestDto request) {

        Wallet wallet = walletService.debiter(walletId, request.getMontant());
        return ResponseEntity.ok(WalletMapper.toDto(wallet));
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<WalletResponseDto> getById(@PathVariable Long walletId) {
        return ResponseEntity.ok(WalletMapper.toDto(walletService.findById(walletId)));
    }
}
