package Reuniao.model;

import Reuniao.dto.ReuniaoRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.util.Date;

@Table(name = "reuniao")
@Entity(name = "reuniao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idReuniao")
public class Reuniao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long idReuniao;
    private String sAssuntoReuniao;
    private String sDescricaoReuniao;
    private String sObservacoes;
    private Date dInicioReuniao;
    private Date dFimReuniao;

    public Reuniao(ReuniaoRequestDTO data){
        this.sAssuntoReuniao = data.sAssuntoReuniao();
        this.sDescricaoReuniao = data.sDescricaoReuniao();
        this.sObservacoes = data.sObservacoes();
        this.dInicioReuniao = data.dInicioReuniao();
        this.dFimReuniao = data.dFimReuniao();
    }
}
