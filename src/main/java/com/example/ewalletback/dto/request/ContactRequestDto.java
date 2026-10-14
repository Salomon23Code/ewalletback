package com.example.ewalletback.dto.request;

import lombok.Data;

@Data
public class ContactRequestDto {

    private String nom;
    private String telephone;
    private Long userId;
}
