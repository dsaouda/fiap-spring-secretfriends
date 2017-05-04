package com.github.dsaouda.fiap.spring.secretfriends.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.dsaouda.fiap.spring.secretfriends.model.Participante;
import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;

public interface ParticipanteRepository extends CrudRepository<Participante, Long> {

	public Participante findByUuid(String uuid);
	public void deleteByUuid(String uuid);
	public Iterable<Participante> findByParticipante(Usuario usuario);
}
