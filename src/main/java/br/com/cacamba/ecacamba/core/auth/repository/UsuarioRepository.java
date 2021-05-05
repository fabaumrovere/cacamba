package br.com.cacamba.ecacamba.core.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cacamba.ecacamba.core.auth.model.UsuarioEntity;

@Repository  
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {  

	UsuarioEntity findByLogin(String login);
	
}