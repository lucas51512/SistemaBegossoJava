package Pessoa.dto;

import java.text.DateFormat;
import java.time.LocalDate;

public record PessoaRequestDTO(String sNome, String sEmail, String sTelefone, String sCpf, LocalDate dDataNascimento, String sEndereco) {
}
