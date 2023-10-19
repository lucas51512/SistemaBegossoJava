package Usuario.model;

import Usuario.dto.UsuarioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idUsuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private Long idUsuario;
    private String sEmail;
    private String wSenha;

    public Usuario(UsuarioRequestDTO data){
        this.sEmail = data.sEmail();
        this.wSenha = data.sEmail();
    }
}
