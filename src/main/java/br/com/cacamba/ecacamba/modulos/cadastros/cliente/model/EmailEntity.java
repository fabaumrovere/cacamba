package br.com.cacamba.ecacamba.modulos.cadastros.cliente.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity( name = "tb_email")
@Getter @Setter @ToString
public class EmailEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_email_id_seq")
   @SequenceGenerator( name = "tb_email_id_seq", sequenceName = "tb_email_id_seq", allocationSize = 1 )
   private Long id;
   
   @JoinColumn( name = "id_cliente" )
   @ManyToOne( fetch = FetchType.LAZY )
   private ClienteEntity cliente;
   
   @NotBlank
   @Column(length=100)
   private String email;

   @Column(length=50)
   private String pessoa;
}
