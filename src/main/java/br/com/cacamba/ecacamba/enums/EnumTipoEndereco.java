package br.com.cacamba.ecacamba.enums;

import lombok.Getter;

@Getter
public enum EnumTipoEndereco {

   C ( "Cobrança "),
   E ( "Entrega" );
   
   private String descricao;
   
   EnumTipoEndereco( String descricao ){
	  this.descricao = descricao;
   }
   
}

