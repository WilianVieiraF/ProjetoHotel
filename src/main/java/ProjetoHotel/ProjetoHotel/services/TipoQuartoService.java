package com.example.hotel.services;

import com.example.hotel.dto.TipoQuartoDTO;
import com.example.hotel.entity.TipoQuarto;
import com.example.hotel.mapper.TipoQuartoMapper;
import com.example.hotel.repositories.TipoQuartoRepository;
import com.example.hotel.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoQuartoService {

    @Autowired
    private TipoQuartoRepository repository;

    @Autowired
    private TipoQuartoMapper mapper;

    @Transactional(readOnly = true)
    public List<TipoQuartoDTO> findAll() {
        List<TipoQuarto> entities = repository.findAll();
        return mapper.toDTOList(entities);
    }

    @Transactional(readOnly = true)
    public TipoQuartoDTO findById(Long id) {
        TipoQuarto entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoQuarto not found"));
        return mapper.toDTO(entity);
    }

    @Transactional
    public TipoQuartoDTO insert(TipoQuartoDTO dto) {
        TipoQuarto entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Transactional
    public TipoQuartoDTO update(Long id, TipoQuartoDTO dto) {
        TipoQuarto entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoQuarto not found"));
        mapper.updateEntityFromDTO(dto, entity);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("TipoQuarto not found");
        }
        repository.deleteById(id);
    }
}