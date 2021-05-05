package br.com.cacamba.ecacamba.modulos.cadastros.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cacamba.ecacamba.modulos.cadastros.cliente.model.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity, Long>{

}
