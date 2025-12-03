package com.example.hotel.resources;

import com.example.hotel.dto.ServicoDTO;
import com.example.hotel.services.ServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/servicos")
public class ServicoResource {

    @Autowired
    private ServicoService service;

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> findAll() {
        List<ServicoDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDTO> findById(@PathVariable Long id) {
        ServicoDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ServicoDTO> insert(@Valid @RequestBody ServicoDTO dto) {
        ServicoDTO createdDto = service.insert(dto);
        URI uri = fromCurrentRequest().path("/{id}").buildAndExpand(createdDto.getId()).toUri();
        return ResponseEntity.created(uri).body(createdDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoDTO> update(@PathVariable Long id, @Valid @RequestBody ServicoDTO dto) {
        ServicoDTO updatedDto = service.update(id, dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}