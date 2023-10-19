package Pessoa.controller;

import Pessoa.dto.PessoaRequestDTO;
import Pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Pessoa.dto.PessoaResponseDTO;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
    private final PessoaService pessoaService;

    @Autowired()
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public void create(@RequestBody PessoaRequestDTO data){
        pessoaService.create(data);
    }

    @GetMapping
    public List<PessoaResponseDTO> getAll(){
        return pessoaService.getAll();
    }

    @GetMapping("{id}")
    public PessoaResponseDTO getOne(@PathVariable Long id) {
        return pessoaService.getOne(id);
    }

    @PatchMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        pessoaService.update(id, updates);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        pessoaService.delete(id);
    }
}
