package com.example.ewalletback.mapper;

import com.example.ewalletback.dto.request.ContactRequestDto;
import com.example.ewalletback.dto.response.ContactResponseDto;
import com.example.ewalletback.models.Contact;
import com.example.ewalletback.models.Users;

public final class ContactMapper {

    private ContactMapper() {
    }

    public static Contact toEntity(ContactRequestDto dto, Users user) {
        Contact contact = new Contact();
        contact.setNom(dto.getNom());
        contact.setTelephone(dto.getTelephone());
        contact.setUser(user);
        return contact;
    }

    public static ContactResponseDto toDto(Contact contact) {
        ContactResponseDto dto = new ContactResponseDto();
        dto.setId(contact.getId());
        dto.setNom(contact.getNom());
        dto.setTelephone(contact.getTelephone());
        if (contact.getUser() != null) {
            dto.setUserId(contact.getUser().getId());
        }
        return dto;
    }
}
