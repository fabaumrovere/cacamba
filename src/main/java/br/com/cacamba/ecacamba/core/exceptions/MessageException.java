package br.com.cacamba.ecacamba.core.exceptions;

import java.util.Map;

public interface MessageException {

   String getExceptionKey();
   ExceptionType getTypeException();
   Map<String, Object> getMapDetails();
}
