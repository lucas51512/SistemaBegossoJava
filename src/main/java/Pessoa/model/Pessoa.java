package Pessoa.model;

import Pessoa.dto.PessoaRequestDTO;
import Usuario.model.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.text.DateFormat;
import java.time.LocalDate;

@Table(name = "pessoas")
@Entity(name = "pessoas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idPessoa")
public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private Long idPessoa;
    private String sNome;
    private String sEmail;
    private String sTelefone;
    private String sCpf;
    private LocalDate dDataNascimento;
    private String sEndereco;

    @OneToOne @MapsId
    public Usuario usuario;

    public Pessoa(PessoaRequestDTO data){
        this.sNome = data.sNome();
        this.sEmail = data.sEmail();
        this.sTelefone = data.sTelefone();
        this.sCpf = data.sCpf();
        this.dDataNascimento = data.dDataNascimento();
        this.sEndereco = data.sEndereco();
    }
}
