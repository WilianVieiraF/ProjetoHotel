package com.example.hotel.services;

import com.example.hotel.dto.QuartoDTO;
import com.example.hotel.entity.Quarto;
import com.example.hotel.mapper.QuartoMapper;
import com.example.hotel.repositories.QuartoRepository;
import com.example.hotel.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository repository;

    @Autowired
    private QuartoMapper mapper;

    @Transactional(readOnly = true)
    public List<QuartoDTO> findAll() {
        List<Quarto> quartos = repository.findAll();
        return mapper.toDTOList(quartos);
    }

    @Transactional(readOnly = true)
    public QuartoDTO findById(Long id) {
        Quarto quarto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quarto not found with id: " + id));
        return mapper.toDTO(quarto);
    }

    @Transactional
    public QuartoDTO insert(QuartoDTO dto) {
        Quarto quarto = mapper.toEntity(dto);
        quarto = repository.save(quarto);
        return mapper.toDTO(quarto);
    }

    @Transactional
    public QuartoDTO update(Long id, QuartoDTO dto) {
        Quarto quarto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quarto not found with id: " + id));
        mapper.updateEntityFromDTO(dto, quarto);
        quarto = repository.save(quarto);
        return mapper.toDTO(quarto);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Quarto not found with id: " + id);
        }
        repository.deleteById(id);
    }
}