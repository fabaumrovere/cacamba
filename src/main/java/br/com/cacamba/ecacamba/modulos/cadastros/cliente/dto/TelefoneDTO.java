package br.com.cacamba.ecacamba.modulos.cadastros.cliente.dto;

import br.com.cacamba.ecacamba.enums.EnumTipoTelefone;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TelefoneDTO {

   private Long id;
   private EnumTipoTelefone tipo;
   private String numero;
   private String pessoa;
}
