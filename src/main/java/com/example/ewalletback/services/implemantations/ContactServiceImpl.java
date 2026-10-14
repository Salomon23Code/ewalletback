package com.example.ewalletback.services.implemantations;

import com.example.ewalletback.models.Contact;
import com.example.ewalletback.repository.ContactRepository;
import com.example.ewalletback.services.ContactService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;

    @Override
    public Contact save(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public List<Contact> findAll() {
        return repository.findAll();
    }

}
