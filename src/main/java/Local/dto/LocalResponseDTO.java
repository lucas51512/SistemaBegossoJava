package Local.dto;

import Local.model.Local;

public record LocalResponseDTO(String sNomeLocal, String sEderecoLocal) {
    public LocalResponseDTO(Local local){
        this(local.getSNomeLocal(), local.getSEnderecoLocal());
    }
}
