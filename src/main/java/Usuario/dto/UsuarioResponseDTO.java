package Usuario.dto;

import Usuario.model.Usuario;

public record UsuarioResponseDTO(String sEmail, String wSenha ) {
    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getSEmail(), usuario.getWSenha());
    }
}
