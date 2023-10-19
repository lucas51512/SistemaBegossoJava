package Local.controller;

import Local.dto.LocalRequestDTO;
import Local.dto.LocalResponseDTO;
import Local.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("local")
public class LocalController {
    private final LocalService localService;

    @Autowired()
    public LocalController(LocalService localService) { this.localService = localService; }

    @PostMapping
    public void create(@RequestBody LocalRequestDTO data) { localService.create(data); }

    @GetMapping
    public List<LocalResponseDTO> getAll() { return localService.getAll(); }

    @GetMapping("{id}")
    public LocalResponseDTO getOne(@PathVariable Long id){ return localService.getOne(id); }

    @PatchMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        localService.update(id, updates);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) { localService.delete(id); }
}
