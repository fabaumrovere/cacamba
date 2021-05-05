package br.com.cacamba.ecacamba.core.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.cacamba.ecacamba.core.auth.dto.UsuarioCustomDTO;
import br.com.cacamba.ecacamba.core.auth.repository.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

   @Bean
   public AuthenticationManager customAuthenticationManager() throws Exception {
	  return authenticationManagerBean();
   }

   @Autowired
   public void authenticationManager(AuthenticationManagerBuilder builder, UsuarioRepository usuarioRepository) throws Exception {
	  builder.userDetailsService(login -> {

		 UsuarioCustomDTO usuarioCustomDTO = new UsuarioCustomDTO(usuarioRepository.findByLogin(login));
		 
		 return usuarioCustomDTO;
		 
	  }).passwordEncoder(passwordEncoder());
   }

   @Bean
   public static BCryptPasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder();
   }
}