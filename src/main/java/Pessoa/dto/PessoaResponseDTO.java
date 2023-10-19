package Pessoa.dto;

import Pessoa.model.Pessoa;

import java.text.DateFormat;
import java.time.LocalDate;

public record PessoaResponseDTO(String sNome, String sEmail, String sTelefone, String sCpf, LocalDate sDataNascimento, String sEndereco) {
    public PessoaResponseDTO(Pessoa pessoa){
        this(pessoa.getSNome(), pessoa.getSEmail(), pessoa.getSTelefone(), pessoa.getSCpf(), pessoa.getDDataNascimento(), pessoa.getSEndereco());
    }
}
