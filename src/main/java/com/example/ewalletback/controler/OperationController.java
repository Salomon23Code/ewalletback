package com.example.ewalletback.controler;

import com.example.ewalletback.dto.response.OperationResponseDto;
import com.example.ewalletback.mapper.OperationMapper;
import com.example.ewalletback.services.implemantations.OperationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operations")
@RequiredArgsConstructor
public class OperationController {

    private final OperationServiceImpl operationService;

    @GetMapping
    public ResponseEntity<List<OperationResponseDto>> getAll() {
        return ResponseEntity.ok(
                operationService.findAll().stream()
                        .map(OperationMapper::toDto)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<OperationResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(OperationMapper.toDto(operationService.findById(id)));
    }

    @GetMapping("/wallet/{walletId}")
    public ResponseEntity<List<OperationResponseDto>> historique(@PathVariable Long walletId) {
        return ResponseEntity.ok(
                operationService.historique(walletId).stream()
                        .map(OperationMapper::toDto)
                        .toList()
        );
    }
}
