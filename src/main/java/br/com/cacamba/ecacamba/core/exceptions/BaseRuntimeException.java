package br.com.cacamba.ecacamba.core.exceptions;

import java.util.Map;

public abstract class BaseRuntimeException extends RuntimeException implements MessageException {

   private final Map<String, Object> mapDetails;

   private final ExceptionType type;

   public BaseRuntimeException(ExceptionType type) {
	  this.type = type;
	  mapDetails = null;
   }

   public BaseRuntimeException(ExceptionType type, final Map<String, Object> mapDetails) {
	  this.type = type;
	  this.mapDetails = mapDetails;
   }

   public abstract String getExceptionKey();

   public ExceptionType getTypeException() {
	  return this.type;
   }

   public Map<String, Object> getMapDetails() {
	  return this.mapDetails;
   }
}