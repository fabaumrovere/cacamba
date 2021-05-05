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

import br.com.cacamba.ecacamba.enums.EnumTipoTelefone;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity( name = "tb_telefone")
@Getter @Setter @ToString
public class TelefoneEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_telefone_id_seq")
   @SequenceGenerator( name = "tb_telefone_id_seq", sequenceName = "tb_telefone_id_seq", allocationSize = 1 )
   private Long id;
   
   @JoinColumn( name = "id_cliente" )
   @ManyToOne( fetch = FetchType.LAZY )
   private ClienteEntity cliente;
   
   @NotNull
   @Enumerated( EnumType.STRING )
   @Column(length=7)
   private EnumTipoTelefone tipo;
   
   @NotBlank
   @Column(length=15)
   private String numero;

   @Column(length=20)
   private String pessoa;
}
