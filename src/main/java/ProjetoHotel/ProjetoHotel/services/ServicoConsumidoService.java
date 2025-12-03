package com.example.hotel.services;

import com.example.hotel.dto.ServicoConsumidoDTO;
import com.example.hotel.entity.ServicoConsumido;
import com.example.hotel.mapper.ServicoConsumidoMapper;
import com.example.hotel.repositories.ServicoConsumidoRepository;
import com.example.hotel.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicoConsumidoService {

    @Autowired
    private ServicoConsumidoRepository repository;

    @Autowired
    private ServicoConsumidoMapper mapper;

    @Transactional(readOnly = true)
    public List<ServicoConsumidoDTO> findAll() {
        List<ServicoConsumido> entities = repository.findAll();
        return mapper.toDTOList(entities);
    }

    @Transactional(readOnly = true)
    public ServicoConsumidoDTO findById(Long id) {
        ServicoConsumido entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ServicoConsumido not found"));
        return mapper.toDTO(entity);
    }

    @Transactional
    public ServicoConsumidoDTO insert(ServicoConsumidoDTO dto) {
        ServicoConsumido entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Transactional
    public ServicoConsumidoDTO update(Long id, ServicoConsumidoDTO dto) {
        ServicoConsumido entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ServicoConsumido not found"));
        mapper.updateEntityFromDTO(dto, entity);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("ServicoConsumido not found");
        }
        repository.deleteById(id);
    }
}