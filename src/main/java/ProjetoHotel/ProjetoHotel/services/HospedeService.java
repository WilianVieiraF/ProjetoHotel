package com.example.hotel.services;

import com.example.hotel.dto.HospedeDTO;
import com.example.hotel.entity.Hospede;
import com.example.hotel.mapper.HospedeMapper;
import com.example.hotel.repositories.HospedeRepository;
import com.example.hotel.exceptions.DatabaseException;
import com.example.hotel.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository repository;

    @Autowired
    private HospedeMapper mapper;

    @Transactional(readOnly = true)
    public List<HospedeDTO> findAll() {
        List<Hospede> entities = repository.findAll();
        return mapper.toDTOList(entities);
    }

    @Transactional(readOnly = true)
    public HospedeDTO findById(Long id) {
        Hospede entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hospede not found"));
        return mapper.toDTO(entity);
    }

    @Transactional
    public HospedeDTO insert(HospedeDTO dto) {
        Hospede entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Transactional
    public HospedeDTO update(Long id, HospedeDTO dto) {
        try {
            Hospede entity = repository.getReferenceById(id);
            mapper.updateEntityFromDTO(dto, entity);
            entity = repository.save(entity);
            return mapper.toDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Hospede not found");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Hospede not found");
        }
        repository.deleteById(id);
    }
}