package com.github.dsaouda.fiap.spring.secretfriends.repository;

import org.springframework.data.repository.CrudRepository;
import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	public Usuario findByUuid(String uuid);
	public void deleteByUuid(String uuid);
	public Usuario findByEmail(String email);
}
