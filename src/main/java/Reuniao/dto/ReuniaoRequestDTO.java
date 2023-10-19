package Reuniao.dto;

import java.util.Date;

public record ReuniaoRequestDTO(String sAssuntoReuniao, String sDescricaoReuniao, String sObservacoes, Date dInicioReuniao, Date dFimReuniao) {
}
