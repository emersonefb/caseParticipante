package br.com.efb.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class CredenciaisDTO {

    @NotEmpty(message = "Inserir Login")
    private String login;

    @NotEmpty(message = "Inserir senha")
    private String senha;

}
