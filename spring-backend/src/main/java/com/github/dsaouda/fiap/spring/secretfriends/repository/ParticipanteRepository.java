package com.github.dsaouda.fiap.spring.secretfriends.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;
import com.github.dsaouda.fiap.spring.secretfriends.model.Participante;
import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;

public interface ParticipanteRepository extends CrudRepository<Participante, Long> {

	public Participante findByUuid(String uuid);
	public void deleteByUuid(String uuid);
	public Iterable<Participante> findByParticipante(Usuario usuario);
	public List<Participante> findByGrupo(Grupo grupo);
}
