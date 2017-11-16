package com.hotmart.suggest.api.security.service;

import java.util.Optional;

import com.hotmart.suggest.api.security.entity.Usuario;

public interface UsuarioService {

	/**
	 * Busca e retorna um usuário dado um email.
	 * 
	 * @param email
	 * @return Optional<Usuario>
	 */
	Optional<Usuario> buscarPorEmail(String email);

}
