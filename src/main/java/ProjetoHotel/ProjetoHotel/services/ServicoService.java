package ProjetoHotel.ProjetoHotel.services;

import ProjetoHotel.ProjetoHotel.dto.ServicoDTO;
import ProjetoHotel.ProjetoHotel.entity.Servico;
import ProjetoHotel.ProjetoHotel.mapper.ServicoMapper;
import ProjetoHotel.ProjetoHotel.repositories.ServicoRepository;
import ProjetoHotel.ProjetoHotel.exceptions.DatabaseException;
import ProjetoHotel.ProjetoHotel.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException; // Added import statement

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    @Autowired
    private ServicoMapper mapper;

    @Transactional(readOnly = true)
    public List<ServicoDTO> findAll() {
        List<Servico> entities = repository.findAll();
        return mapper.toDTOList(entities);
    }

    @Transactional(readOnly = true)
    public ServicoDTO findById(Long id) {
        Servico entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Serviço não encontrado"));
        return mapper.toDTO(entity);
    }

    @Transactional
    public ServicoDTO insert(ServicoDTO dto) {
        Servico entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDTO(entity);
    }

    @Transactional
    public ServicoDTO update(Long id, ServicoDTO dto) {
        try {
            Servico entity = repository.getReferenceById(id);
            mapper.updateEntityFromDTO(dto, entity);
            entity = repository.save(entity);
            return mapper.toDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Serviço não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Serviço não encontrado");
        }
        repository.deleteById(id);
    }
}