package com.example.hotel.services;

import com.example.hotel.dto.ReservaDTO;
import com.example.hotel.entity.Reserva;
import com.example.hotel.mapper.ReservaMapper;
import com.example.hotel.repositories.ReservaRepository;
import com.example.hotel.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ReservaMapper reservaMapper;

    @Transactional(readOnly = true)
    public List<ReservaDTO> findAll() {
        List<Reserva> reservas = reservaRepository.findAll();
        return reservaMapper.toDTOList(reservas);
    }

    @Transactional(readOnly = true)
    public ReservaDTO findById(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva not found with id: " + id));
        return reservaMapper.toDTO(reserva);
    }

    @Transactional
    public ReservaDTO insert(ReservaDTO dto) {
        Reserva reserva = reservaMapper.toEntity(dto);
        reserva = reservaRepository.save(reserva);
        return reservaMapper.toDTO(reserva);
    }

    @Transactional
    public ReservaDTO update(Long id, ReservaDTO dto) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva not found with id: " + id));
        reservaMapper.updateEntityFromDTO(dto, reserva);
        reserva = reservaRepository.save(reserva);
        return reservaMapper.toDTO(reserva);
    }

    @Transactional
    public void delete(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reserva not found with id: " + id);
        }
        reservaRepository.deleteById(id);
    }
}