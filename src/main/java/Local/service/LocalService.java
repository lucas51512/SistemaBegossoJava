package Local.service;

import Local.LocalRepository;
import Local.dto.LocalRequestDTO;
import Local.dto.LocalResponseDTO;
import Local.model.Local;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LocalService {

    private final LocalRepository localRepository;

    @Autowired()
    public LocalService(LocalRepository localRepository) { this.localRepository = localRepository; }

    public void create(LocalRequestDTO data) {
        Local localData = new Local(data);
        localRepository.save(localData);
    }

    public List<LocalResponseDTO> getAll() {
        return localRepository.findAll().stream().map(LocalResponseDTO::new).toList();
    }

    public LocalResponseDTO getOne(Long id) {
        Local local = localRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Local não encontrado"));
        return new LocalResponseDTO(local);
    }

    public void update(Long id, Map<String, Object> updates) {
        Local local = localRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Local não encontrado"));

        updates.forEach((field, value) -> {
            if("sNomeLocal".equals(field)){
                local.setSNomeLocal((String) value);
            }else if ("sEnderecoLocal".equals(field)){
                local.setSEnderecoLocal((String) value);
            }
        });
    }

    public void delete(Long id) {
        Local local = localRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Local não encontrado"));
        localRepository.delete(local);
    }
}
