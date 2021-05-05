package br.com.cacamba.ecacamba.modulos.cadastros.cliente.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity( name = "tb_construtor")
@Getter @Setter @ToString
public class ConstrutorEntity {

   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY)
   private Long id;
   
   @JoinColumn( name = "id_cliente" )
   @ManyToOne( fetch = FetchType.LAZY )
   private ClienteEntity cliente;
}
