package com.example.ewalletback.controler;

import com.example.ewalletback.dto.request.AchatRequestDto;
import com.example.ewalletback.dto.response.AchatResponseDto;
import com.example.ewalletback.mapper.AchatMapper;
import com.example.ewalletback.models.Achat;
import com.example.ewalletback.models.Wallet;
import com.example.ewalletback.services.implemantations.AchatServiceImpl;
import com.example.ewalletback.services.implemantations.WalletServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/achats")
@RequiredArgsConstructor
public class AchatController {

    private final AchatServiceImpl achatService;
    private final WalletServiceImpl walletService;

    @PostMapping
    public ResponseEntity<AchatResponseDto> effectuerAchat(@RequestBody AchatRequestDto request) {
        Wallet wallet = walletService.findById(request.getWalletId());
        Achat achat = achatService.effectuerAchat(AchatMapper.toEntity(request, wallet));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(AchatMapper.toDto(achat));
    }
}
