package com.example.hotel.resources;

import com.example.hotel.dto.TipoQuartoDTO;
import com.example.hotel.services.TipoQuartoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/tipos-quarto")
public class TipoQuartoResource {

    @Autowired
    private TipoQuartoService service;

    @GetMapping
    public ResponseEntity<List<TipoQuartoDTO>> findAll() {
        List<TipoQuartoDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoQuartoDTO> findById(@PathVariable Long id) {
        TipoQuartoDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TipoQuartoDTO> insert(@Valid @RequestBody TipoQuartoDTO dto) {
        TipoQuartoDTO createdDto = service.insert(dto);
        URI uri = fromCurrentRequest().path("/{id}").buildAndExpand(createdDto.getId()).toUri();
        return ResponseEntity.created(uri).body(createdDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoQuartoDTO> update(@PathVariable Long id, @Valid @RequestBody TipoQuartoDTO dto) {
        TipoQuartoDTO updatedDto = service.update(id, dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}