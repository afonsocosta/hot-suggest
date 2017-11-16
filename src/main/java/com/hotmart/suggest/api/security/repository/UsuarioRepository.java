package com.hotmart.suggest.api.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotmart.suggest.api.security.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByEmail(String email);
	
}
