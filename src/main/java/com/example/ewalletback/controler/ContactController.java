package com.example.ewalletback.controler;

import com.example.ewalletback.dto.request.ContactRequestDto;
import com.example.ewalletback.dto.response.ContactResponseDto;
import com.example.ewalletback.mapper.ContactMapper;
import com.example.ewalletback.models.Contact;
import com.example.ewalletback.models.Users;
import com.example.ewalletback.services.implemantations.ContactServiceImpl;
import com.example.ewalletback.services.implemantations.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactServiceImpl contactService;
    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<ContactResponseDto> create(@RequestBody ContactRequestDto request) {
        Users user = userService.findById(request.getUserId());
        Contact contact = contactService.save(ContactMapper.toEntity(request, user));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ContactMapper.toDto(contact));
    }

    @GetMapping
    public ResponseEntity<List<ContactResponseDto>> getAll() {
        return ResponseEntity.ok(
                contactService.findAll().stream()
                        .map(ContactMapper::toDto)
                        .toList()
        );
    }
}
