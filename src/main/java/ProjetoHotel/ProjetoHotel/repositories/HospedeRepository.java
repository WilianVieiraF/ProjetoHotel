package com.example.hotel.repositories;

import com.example.hotel.entity.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}