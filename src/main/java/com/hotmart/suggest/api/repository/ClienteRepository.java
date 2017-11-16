package com.hotmart.suggest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hotmart.suggest.api.entity.Cliente;

@Transactional(readOnly=true)
public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryCustom{
	
	Cliente findByNome(String nome);
	
	Cliente findByCpf(String cpf);
	
}
