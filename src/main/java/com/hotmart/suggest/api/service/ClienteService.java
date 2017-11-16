package com.hotmart.suggest.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hotmart.suggest.api.entity.Cliente;
import com.hotmart.suggest.api.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private Logger logger =  LoggerFactory.getLogger(ClienteService.class);
	
	@Autowired
	private ClienteRepository clienteRepository;

	@SuppressWarnings("unchecked")
	public List<Cliente> findAll(Pageable pageable) {
		List<Cliente> findAll = (List<Cliente>) clienteRepository.findAll(pageable);
		return findAll;
	}
	
	public Cliente findByName(String name){
		logger.info("Buscando um cliene pelo nome {}",name);
		return clienteRepository.customMethod(name);
	}
	
	public Cliente findByCpf(){
		return clienteRepository.findByCpf("12345678909");
	}
	
	
}
