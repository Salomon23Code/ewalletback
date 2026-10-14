package com.example.ewalletback.services.implemantations;

import com.example.ewalletback.models.Users;
import com.example.ewalletback.repository.UserRepository;
import com.example.ewalletback.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Users save(Users user) {
        user.setDateinscription(LocalDateTime.now());
        return repository.save(user);
    }

    @Override
    public Users findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
    }

    @Override
    public List<Users> findAll() {
        return repository.findAll();
    }

    @Override
    public Users update(Long id, Users user) {

        Users u = findById(id);

        u.setNom(user.getNom());
        u.setPhone(user.getPhone());
        u.setEmail(user.getEmail());

        return repository.save(u);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
