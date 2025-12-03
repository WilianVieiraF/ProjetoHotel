package com.example.hotel.resources;

import com.example.hotel.dto.ReservaDTO;
import com.example.hotel.services.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/reservas")
public class ReservaResource {

    @Autowired
    private ReservaService service;

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> findAll() {
        List<ReservaDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable Long id) {
        ReservaDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> insert(@Valid @RequestBody ReservaDTO dto) {
        ReservaDTO createdDto = service.insert(dto);
        URI uri = fromCurrentRequest().path("/{id}").buildAndExpand(createdDto.getId()).toUri();
        return ResponseEntity.created(uri).body(createdDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> update(@PathVariable Long id, @Valid @RequestBody ReservaDTO dto) {
        ReservaDTO updatedDto = service.update(id, dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}