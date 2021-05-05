package br.com.cacamba.ecacamba.modulos.cadastros.cliente.dto;

import br.com.cacamba.ecacamba.enums.EnumTipoEndereco;
import br.com.cacamba.ecacamba.enums.EnumTipoLogradouro;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EnderecoDTO {

   private Long id;
   private EnumTipoEndereco tipo;
   private EnumTipoLogradouro tipoLogradouro;
   private String logradouro;
   private String numero;
   private String complemento;
   private String bairro;
   private String cidade;
   private String cep;


   
}
