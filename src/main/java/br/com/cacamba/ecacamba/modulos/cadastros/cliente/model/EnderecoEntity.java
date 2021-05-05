package br.com.cacamba.ecacamba.modulos.cadastros.cliente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.cacamba.ecacamba.enums.EnumTipoEndereco;
import br.com.cacamba.ecacamba.enums.EnumTipoLogradouro;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity( name = "tb_endereco")
@Getter @Setter @ToString
public class EnderecoEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_endereco_id_seq")
   @SequenceGenerator( name = "tb_endereco_id_seq", sequenceName = "tb_endereco_id_seq", allocationSize = 1 )
   private Long id;
   
   @JoinColumn( name = "id_cliente" )
   @ManyToOne( fetch = FetchType.LAZY )
   private ClienteEntity cliente;
   
   @NotNull
   @Enumerated( EnumType.STRING )
   private EnumTipoEndereco tipo;
   
   @NotNull
   @Enumerated( EnumType.STRING )
   @Column(name = "tipo_logradouro", length = 20)
   private EnumTipoLogradouro tipoLogradouro;

   @NotBlank
   @Column(length=100)
   private String logradouro;
   
   @NotBlank
   @Column(length=20)
   private String numero;

   @Column(length=50)
   private String complemento;
   
   @NotBlank
   @Column(length=50)
   private String bairro;
   
   @NotBlank
   @Column(length=50)
   private String cidade;
   
   @NotBlank
   @Column(length=10)
   private String cep;

}
