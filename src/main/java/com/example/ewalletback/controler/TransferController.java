package com.example.ewalletback.controler;

import com.example.ewalletback.dto.request.TransferRequestDto;
import com.example.ewalletback.dto.response.TransferResponseDto;
import com.example.ewalletback.mapper.TransferMapper;
import com.example.ewalletback.models.Transfer;
import com.example.ewalletback.models.Wallet;
import com.example.ewalletback.services.implemantations.TransferServiceImpl;
import com.example.ewalletback.services.implemantations.WalletServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferServiceImpl transferService;
    private final WalletServiceImpl walletService;

    @PostMapping
    public ResponseEntity<TransferResponseDto> effectuerTransfert(@RequestBody TransferRequestDto request) {
        Wallet walletSource = walletService.findById(request.getWalletId());
        Wallet walletDestinataire = walletService.findById(request.getWalletDestinataireId());

        Transfer transfer = transferService.effectuerTransfert(
                TransferMapper.toEntity(request, walletSource, walletDestinataire)
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(TransferMapper.toDto(transfer));
    }
}
