package br.com.cacamba.ecacamba.core.auth.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import br.com.cacamba.ecacamba.core.auth.dto.UsuarioCustomDTO;

public class CustomTokenEnhancer implements TokenEnhancer {

   @Override
   public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
       
	  if( !( authentication.getUserAuthentication().getPrincipal() instanceof UsuarioCustomDTO ) ) {
		 return accessToken;
	  }

	  UsuarioCustomDTO user = (UsuarioCustomDTO) authentication.getUserAuthentication().getPrincipal();
	  
	  Map<String, Object> additionalInfo = new HashMap<>();

	  additionalInfo.put("usuario", user.getNome() );

	  ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

	  return accessToken;
   }
}
