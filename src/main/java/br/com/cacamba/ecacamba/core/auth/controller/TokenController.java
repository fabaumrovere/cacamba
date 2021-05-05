package br.com.cacamba.ecacamba.core.auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("token")
public class TokenController {

   @GetMapping("/check")
   public User checkToken() {
	  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	  
	  if( authentication == null || "anonymousUser".equals( authentication.getName() ) ) {
		 throw new UnauthorizedClientException( "Usuário não encontrado!" );
	  }
	  
	  return new User( authentication.getName() );
   }

   @Getter
   @Setter
   private class User {
	  
	  private String user;

	  public User(String user) {
		 this.user = user;
	  }
	  
   }
}
