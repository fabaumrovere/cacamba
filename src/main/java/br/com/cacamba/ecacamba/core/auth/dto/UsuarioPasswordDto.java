package br.com.cacamba.ecacamba.core.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioPasswordDto {

   private String senhaAtual;
   private String novaSenha;
}
