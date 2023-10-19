package Local.model;

import Local.dto.LocalRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "local")
@Entity(name = "local")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idLocal")
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long idLocal;
    private String sNomeLocal;
    private String sEnderecoLocal;

    public Local(LocalRequestDTO data){
        this.sNomeLocal = data.sNomeLocal();
        this.sEnderecoLocal = data.sEnderecoLocal();
    }
}
