package com.example.hotel.resources;

import com.example.hotel.dto.ServicoConsumidoDTO;
import com.example.hotel.services.ServicoConsumidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/servicos-consumidos")
public class ServicoConsumidoResource {

    @Autowired
    private ServicoConsumidoService service;

    @GetMapping
    public ResponseEntity<List<ServicoConsumidoDTO>> findAll() {
        List<ServicoConsumidoDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoConsumidoDTO> findById(@PathVariable Long id) {
        ServicoConsumidoDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ServicoConsumidoDTO> insert(@Valid @RequestBody ServicoConsumidoDTO dto) {
        ServicoConsumidoDTO createdDto = service.insert(dto);
        URI uri = fromCurrentRequest().path("/{id}").buildAndExpand(createdDto.getId()).toUri();
        return ResponseEntity.created(uri).body(createdDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoConsumidoDTO> update(@PathVariable Long id, @Valid @RequestBody ServicoConsumidoDTO dto) {
        ServicoConsumidoDTO updatedDto = service.update(id, dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}