package br.com.cacamba.ecacamba.modulos.cadastros.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cacamba.ecacamba.modulos.cadastros.cliente.business.ClienteBusiness;
import br.com.cacamba.ecacamba.modulos.cadastros.cliente.dto.ClienteDTO;

@RestController
@RequestMapping( "cliente" )
public class ClienteController {

   @Autowired
   private ClienteBusiness business;
   
   @PostMapping
   public ClienteDTO salvar(@RequestBody ClienteDTO cliente) {
	  return business.doSalvarCliente(cliente);
   }
   
   @GetMapping( "/all" )
   public List<ClienteDTO> findAll(){
	  return business.getAllClientes();
   }
}
