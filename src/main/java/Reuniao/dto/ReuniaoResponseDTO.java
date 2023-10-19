package Reuniao.dto;

import Reuniao.model.Reuniao;

import java.util.Date;

public record ReuniaoResponseDTO(String sAssuntoReuniao, String sDescricaoReuniao, String sObservacoes, Date dInicioReuniao, Date dFimReuniao) {
    public ReuniaoResponseDTO(Reuniao reuniao){
        this(reuniao.getSAssuntoReuniao(), reuniao.getSDescricaoReuniao(), reuniao.getSObservacoes(), reuniao.getDInicioReuniao(), reuniao.getDFimReuniao());
    }
}
