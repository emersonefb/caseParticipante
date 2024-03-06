package br.com.efb.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSearchDTO {
    private int cvIdUsuario;
    private String ccEmailUsu;
    private String ccNomUsuario;
    private String ccSenha;
    private int page;
    private int size;


}
