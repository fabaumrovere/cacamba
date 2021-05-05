package br.com.cacamba.ecacamba.modulos.cadastros.cliente.dto;

import java.util.List;

import br.com.cacamba.ecacamba.enums.EnumTipoPessoa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteDTO {

   private Long id;
   private String nome;
   private String apelido;
   private EnumTipoPessoa tipo;
   private String cpfcnpj;
   private String responsavel;
   private Long construtor;
   private List<EnderecoDTO> enderecos;
   private List<TelefoneDTO> telefones;
   private List<EmailDTO> emails;
   
   
   
}
