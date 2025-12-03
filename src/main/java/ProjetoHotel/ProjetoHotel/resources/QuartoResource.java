package com.example.hotel.resources;

import com.example.hotel.dto.QuartoDTO;
import com.example.hotel.services.QuartoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/quartos")
public class QuartoResource {

    @Autowired
    private QuartoService service;

    @GetMapping
    public ResponseEntity<List<QuartoDTO>> findAll() {
        List<QuartoDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuartoDTO> findById(@PathVariable Long id) {
        QuartoDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<QuartoDTO> insert(@Valid @RequestBody QuartoDTO dto) {
        QuartoDTO createdDto = service.insert(dto);
        URI uri = fromCurrentRequest().path("/{id}").buildAndExpand(createdDto.getId()).toUri();
        return ResponseEntity.created(uri).body(createdDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuartoDTO> update(@PathVariable Long id, @Valid @RequestBody QuartoDTO dto) {
        QuartoDTO updatedDto = service.update(id, dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}