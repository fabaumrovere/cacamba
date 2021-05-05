package br.com.cacamba.ecacamba.core.exceptions;

import java.util.Date;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiErrorDto {

   private Date timestamp;
   private Integer status;
   private String code;
   private Set<ErrorDto> errors;

   public ApiErrorDto() {
   }

   public ApiErrorDto(Date timestamp, Integer status, String code, Set<ErrorDto> errors) {
	  this.timestamp = timestamp;
	  this.status = status;
	  this.code = code;
	  this.errors = errors;
   }
}
