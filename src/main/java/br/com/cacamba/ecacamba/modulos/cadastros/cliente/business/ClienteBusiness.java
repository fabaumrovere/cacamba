package br.com.cacamba.ecacamba.modulos.cadastros.cliente.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cacamba.ecacamba.enums.EnumTipoPessoa;
import br.com.cacamba.ecacamba.modulos.cadastros.cliente.dto.ClienteDTO;
import br.com.cacamba.ecacamba.modulos.cadastros.cliente.model.ClienteEntity;
import br.com.cacamba.ecacamba.modulos.cadastros.cliente.repository.ClienteRepository;
import br.com.cacamba.ecacamba.modulos.cadastros.cliente.repository.EmailRepository;
import br.com.cacamba.ecacamba.modulos.cadastros.cliente.repository.EnderecoRepository;
import br.com.cacamba.ecacamba.modulos.cadastros.cliente.repository.TelefoneRepository;
import br.com.cacamba.ecacamba.utils.ECStringUtils;
import br.com.cacamba.ecacamba.utils.ModelMapperUtils;

@Service
public class ClienteBusiness {

   @Autowired
   private ClienteRepository repository;
   @Autowired
   private EmailRepository emailRepository;
   @Autowired
   private EnderecoRepository enderecoRepository;
   @Autowired
   private TelefoneRepository telefoneRepository;
   
   public ClienteDTO doSalvarCliente( ClienteDTO bean ) {

	  ClienteEntity entidade = ModelMapperUtils.map(bean, ClienteEntity.class );
	  
	  entidade.setTipo( ( ECStringUtils.isEmpty( entidade.getCpfcnpj() ) || entidade.getCpfcnpj().length() == 11 ) ? EnumTipoPessoa.F : EnumTipoPessoa.J );
	  
	  repository.saveAndFlush( entidade );
	  
	  entidade.getEnderecos().stream().forEach( ende -> ende.setCliente(entidade) );
	  enderecoRepository.saveAll( entidade.getEnderecos() );
	  
	  entidade.getEmails().stream().forEach( email -> email.setCliente(entidade) );
	  emailRepository.saveAll( entidade.getEmails() );

	  entidade.getTelefones().stream().forEach( fone -> fone.setCliente(entidade) );
	  telefoneRepository.saveAll( entidade.getTelefones() );
	  
	  return ModelMapperUtils.map(entidade, ClienteDTO.class);
   }

   public List<ClienteDTO> getAllClientes() {
	  
	  List<ClienteEntity> findAll = repository.findAll();
	  
	  return ModelMapperUtils.mapAll( findAll, ClienteDTO.class );
   }
   
}
