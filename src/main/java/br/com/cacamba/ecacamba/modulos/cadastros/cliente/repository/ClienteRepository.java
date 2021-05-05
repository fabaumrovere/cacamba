package br.com.cacamba.ecacamba.modulos.cadastros.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cacamba.ecacamba.modulos.cadastros.cliente.model.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{

}
