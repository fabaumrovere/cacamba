package br.com.cacamba.ecacamba.modulos.cadastros.cliente.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.cacamba.ecacamba.core.database.anotation.CpfCnpj;
import br.com.cacamba.ecacamba.enums.EnumTipoPessoa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity( name = "tb_cliente")
@Getter @Setter @ToString 

public class ClienteEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_cliente_id_seq")
   @SequenceGenerator( name = "tb_cliente_id_seq", sequenceName = "tb_cliente_id_seq", allocationSize = 1 )
   private Long id;
   
   @NotBlank( message = "Nome é obrigatório")
   @Column(length=100)
   private String nome;

   @Column(length=50)	
   private String apelido;
   
   @NotNull
   @Enumerated(EnumType.STRING)
   @Column(length=1)
   private EnumTipoPessoa tipo;
   
   @CpfCnpj
   @Column( name = "cpf_cnpj", length = 15)
   private String cpfcnpj;
   
   @Column(length=30)
   private String responsavel;

   @ManyToOne(fetch = FetchType.LAZY, optional = true)
   private ClienteEntity construtor;

   @OneToMany( mappedBy="cliente", fetch = FetchType.LAZY )
   private List<EnderecoEntity> enderecos;

   @OneToMany( mappedBy="cliente", fetch = FetchType.LAZY )
   private List<TelefoneEntity> telefones;
   
   @OneToMany( mappedBy="cliente", fetch = FetchType.LAZY )
   private List<EmailEntity> emails;
   
   
}
