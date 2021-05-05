package br.com.cacamba.ecacamba.core.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cacamba.ecacamba.core.auth.dto.UsuarioPasswordDto;
import br.com.cacamba.ecacamba.core.auth.model.UsuarioEntity;
import br.com.cacamba.ecacamba.core.auth.repository.UsuarioRepository;
import br.com.cacamba.ecacamba.core.exceptions.ECValidationException;
import br.com.cacamba.ecacamba.utils.ECStringUtils;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

   @Autowired
   private UsuarioRepository usuarioRepository;

   @GetMapping
   public List<UsuarioEntity> listar() {
	  return usuarioRepository.findAll();
   }

   @PostMapping
   public ResponseEntity<?> salvar(@RequestBody UsuarioEntity usuario) {

	  UsuarioEntity findByLogin = usuarioRepository.findByLogin( ECStringUtils.trim( usuario.getLogin() ) );
	  
	  if( findByLogin != null ) {
		 throw new ECValidationException("Já existe outro usuário com esse nome!");
	  }

	  usuario.setSenha(new BCryptPasswordEncoder().encode("123456"));
	  
	  return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.saveAndFlush(usuario));
   }

   @PutMapping("/changepassword")
   public UsuarioEntity changePassword(@RequestBody UsuarioPasswordDto usuario) {

	  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	  UsuarioEntity findByLogin = usuarioRepository.findByLogin(authentication.getName());

	  boolean senhaOk = new BCryptPasswordEncoder().matches( ECStringUtils.trim( usuario.getSenhaAtual() ), ECStringUtils.trim( findByLogin.getSenha() ) );

	  if (!senhaOk) {
		 throw new ECValidationException("Senha atual inválida!");
	  }

	  findByLogin.setSenha(new BCryptPasswordEncoder().encode(ECStringUtils.trim( usuario.getNovaSenha())));

	  usuarioRepository.saveAndFlush(findByLogin);

	  return findByLogin;
   }
}
