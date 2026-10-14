package com.example.ewalletback.repository;

import com.example.ewalletback.models.Achat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchatRepository extends JpaRepository<Achat,Long > {
}
