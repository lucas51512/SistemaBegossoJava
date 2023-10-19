package Usuario.service;

import Usuario.UsuarioRepository;
import Usuario.dto.UsuarioResponseDTO;
import Usuario.dto.UsuarioRequestDTO;
import Usuario.model.Usuario;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    @Autowired()
    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }


    public void create(@RequestBody UsuarioRequestDTO data){
        Usuario usuarioData = new Usuario(data);
        repository.save(usuarioData);
    }

    public List<UsuarioResponseDTO> getAll(){
        return repository.findAll().stream().map(UsuarioResponseDTO::new).toList();
    }
    public UsuarioResponseDTO getOne(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
        return new UsuarioResponseDTO(usuario);
    }

    public void update(Long id, Map<String, Object> updates){
        Usuario usuario = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        updates.forEach((field, value) -> {
            if ("sEmail".equals(field)){
                usuario.setSEmail((String) value);
            } else if ("wSenha".equals(field)) {
                usuario.setWSenha((String) value);
            }
        });
    }

    public void delete(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        repository.delete(usuario);
    }
}
