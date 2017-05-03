package com.github.dsaouda.fiap.spring.secretfriends.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.dsaouda.fiap.spring.secretfriends.model.Convite;
import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;

public interface ConviteRepository extends CrudRepository<Convite, Long> {

	public Convite findByUuid(String uuid);
	public void deleteByUuid(String uuid);
	public Iterable<Convite> findByGrupo(Grupo grupo);
}
