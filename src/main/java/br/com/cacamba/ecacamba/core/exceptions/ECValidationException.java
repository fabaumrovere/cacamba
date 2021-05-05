package br.com.cacamba.ecacamba.core.exceptions;

public class ECValidationException extends BaseRuntimeException{
   
   private  String message;
   
   public ECValidationException( String message ){
	  super( ExceptionType.VALIDATION );
	  this.message = message;
   }

   @Override
   public String getExceptionKey() {
	  return message;
   }
}
