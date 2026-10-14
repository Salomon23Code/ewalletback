package com.example.ewalletback.controler;

import com.example.ewalletback.dto.request.EnvoiRequestDto;
import com.example.ewalletback.dto.response.EnvoiResponseDto;
import com.example.ewalletback.mapper.EnvoiMapper;
import com.example.ewalletback.models.Envoi;
import com.example.ewalletback.models.Wallet;
import com.example.ewalletback.services.implemantations.EnvoiServiceImpl;
import com.example.ewalletback.services.implemantations.WalletServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/envois")
@RequiredArgsConstructor
public class EnvoiController {

    private final EnvoiServiceImpl envoiService;
    private final WalletServiceImpl walletService;

    @PostMapping
    public ResponseEntity<EnvoiResponseDto> envoyer(@RequestBody EnvoiRequestDto request) {
        Wallet wallet = walletService.findById(request.getWalletId());
        Envoi envoi = envoiService.envoyer(EnvoiMapper.toEntity(request, wallet));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(EnvoiMapper.toDto(envoi));
    }
}
