package ProjetoHotel.ProjetoHotel.resources;

import ProjetoHotel.ProjetoHotel.dto.HospedeDTO;
import ProjetoHotel.ProjetoHotel.services.HospedeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/hospedes")
public class HospedeResource {

    @Autowired
    private HospedeService service;

    @GetMapping
    public ResponseEntity<List<HospedeDTO>> findAll() {
        List<HospedeDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospedeDTO> findById(@PathVariable Long id) {
        HospedeDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<HospedeDTO> insert(@Valid @RequestBody HospedeDTO dto) {
        HospedeDTO createdDto = service.insert(dto);
        URI uri = fromCurrentRequest().path("/{id}").buildAndExpand(createdDto.getId()).toUri();
        return ResponseEntity.created(uri).body(createdDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HospedeDTO> update(@PathVariable Long id, @Valid @RequestBody HospedeDTO dto) {
        HospedeDTO updatedDto = service.update(id, dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}