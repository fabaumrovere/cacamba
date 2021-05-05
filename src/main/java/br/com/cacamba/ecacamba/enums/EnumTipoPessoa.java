package br.com.cacamba.ecacamba.enums;

import lombok.Getter;

@Getter
public enum EnumTipoPessoa {

   F ( "Física" ),
   J ( "Jurídica" );
   
   private String descricao;
   
   EnumTipoPessoa( String descricao ){
	  this.descricao = descricao;
   }
}
