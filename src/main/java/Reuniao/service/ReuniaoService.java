package Reuniao.service;

import Pessoa.model.Pessoa;
import Reuniao.ReuniaoRepository;
import Reuniao.dto.ReuniaoRequestDTO;
import Reuniao.dto.ReuniaoResponseDTO;
import Reuniao.model.Reuniao;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ReuniaoService {
    private final ReuniaoRepository reuniaoRepository;

    @Autowired()
    public ReuniaoService(ReuniaoRepository reuniaoRepository) {
        this.reuniaoRepository = reuniaoRepository;
    }

    public void create(ReuniaoRequestDTO data) {
        Reuniao reuniaoData = new Reuniao(data);
        reuniaoRepository.save(reuniaoData);
    }

    public List<ReuniaoResponseDTO> getAll() {
        return reuniaoRepository.findAll().stream().map(ReuniaoResponseDTO::new).toList();
    }

    public ReuniaoResponseDTO getOne(Long id) {
        Reuniao reuniao = reuniaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Reunião não encontrada"));
        return new ReuniaoResponseDTO(reuniao);
    }

    public void update(Long id, Map<String, Object> updates) {
        Reuniao reuniao = reuniaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Reuniao não encontrada"));

        updates.forEach((field, value) -> {
            if("sAssuntoReuniao".equals(field)){
                reuniao.setSAssuntoReuniao((String) value);
            }else if("sDescricaoReuniao".equals(field)){
                reuniao.setSDescricaoReuniao((String) value);
            }else if("sObservacao".equals(field)){
                reuniao.setSObservacoes((String) value);
            }else if("dInicioReuniao".equals(field)){
                reuniao.setDInicioReuniao((Date) value);
            }else if("dFimReuniao".equals(field)){
                reuniao.setDFimReuniao((Date) value);
            }
        });
    }

    public void delete(Long id) {
        Reuniao reuniao = reuniaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Reuniao não encontrada"));
        reuniaoRepository.delete(reuniao);
    }

}
