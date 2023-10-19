package Usuario.controller;

import Usuario.dto.UsuarioResponseDTO;
import Usuario.dto.UsuarioRequestDTO;
import Usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired()
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public void create(@RequestBody UsuarioRequestDTO data){
        usuarioService.create(data);
    }

    @GetMapping
    public List<UsuarioResponseDTO> getAll(){
        return usuarioService.getAll();
    }

    @GetMapping("{id}")
    public UsuarioResponseDTO getOne(@PathVariable Long id) {
        return usuarioService.getOne(id);
    }

    @PatchMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        usuarioService.update(id, updates);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) { usuarioService.delete(id); }
}
