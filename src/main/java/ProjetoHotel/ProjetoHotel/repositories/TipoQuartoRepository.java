package com.example.hotel.repositories;

import com.example.hotel.entity.TipoQuarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoQuartoRepository extends JpaRepository<TipoQuarto, Long> {
}