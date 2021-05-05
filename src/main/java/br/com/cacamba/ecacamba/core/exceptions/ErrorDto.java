package br.com.cacamba.ecacamba.core.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto{

   private ExceptionType type;
   private String        code;
   private String        message;
   
   public ErrorDto( ExceptionType type, String code, String message ) {
	  this.type = type;
	  this.code = code;
	  this.message = message;
   }
}
