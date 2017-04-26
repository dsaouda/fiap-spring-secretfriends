package com.github.dsaouda.fiap.spring.secretfriends.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;

public interface GrupoRepository extends CrudRepository<Grupo, Long> {

	public Grupo findByUuid(String uuid);
	public void deleteByUuid(String uuid);
}
