package Pessoa.service;

import Pessoa.PessoaRepository;
import Pessoa.dto.PessoaResponseDTO;
import Pessoa.dto.PessoaRequestDTO;
import Pessoa.model.Pessoa;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class PessoaService {
    private final PessoaRepository repository;

    @Autowired()
    public PessoaService(PessoaRepository repository){
        this.repository = repository;
    }

    public void create(@RequestBody PessoaRequestDTO data){
        Pessoa pessoaData = new Pessoa(data);
        repository.save(pessoaData);
    }

    public List<PessoaResponseDTO> getAll(){
        return repository.findAll().stream().map(PessoaResponseDTO::new).toList();
    }
    public PessoaResponseDTO getOne(Long id) {
        Pessoa pessoa = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrado"));
        return new PessoaResponseDTO(pessoa);
    }

    public void update(Long id, Map<String, Object> updates){
        Pessoa pessoa = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        updates.forEach((field, value) -> {
            if ("sNome".equals(field)) {
                pessoa.setSNome((String) value);
            } else if ("sEmail".equals(field)) {
                pessoa.setSEmail((String) value);
            } else if ("sTelefone".equals(field)) {
                pessoa.setSTelefone((String) value );
            } else if ("sCpf".equals(field)) {
                pessoa.setSCpf((String) value);
            } else if ("dDataNascimento".equals(field)) {
                pessoa.setDDataNascimento((LocalDate) value);
            } else if ("sEndereco".equals(field)) {
                pessoa.setSEndereco((String) value);
            }
        });
    }

    public void delete(Long id) {
        Pessoa pessoa = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
        repository.delete(pessoa);
    }
}
