package com.example.ewalletback.services;

import com.example.ewalletback.models.Contact;

import java.util.List;

public interface ContactService {

    Contact save(Contact contact);

    List<Contact> findAll();

}
