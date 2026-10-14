package com.example.ewalletback.repository;

import com.example.ewalletback.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
