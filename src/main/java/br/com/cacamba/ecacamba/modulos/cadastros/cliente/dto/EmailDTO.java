package br.com.cacamba.ecacamba.modulos.cadastros.cliente.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmailDTO {

   private Long id;
   private String email;
   private String pessoa;
}
