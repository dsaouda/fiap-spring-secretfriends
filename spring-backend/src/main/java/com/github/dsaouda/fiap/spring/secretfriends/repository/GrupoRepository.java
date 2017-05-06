package com.github.dsaouda.fiap.spring.secretfriends.repository;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;
import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;

public interface GrupoRepository extends CrudRepository<Grupo, Long> {

	public Grupo findByUuid(String uuid);
	public void deleteByUuid(String uuid);
	public Grupo findByUuidAndAdministrador(String uuid, Usuario administrador);
	public Iterable<Grupo> findByAdministrador(Usuario usuario);
	
	@Query("select g from Grupo g where g.status = 'SORTEIO_NAO_REALIZADO' and g.dataSorteio <= :dataSorteio")
	public Stream<Grupo> streamPrecisaSortear(@Param("dataSorteio") Date dataSorteio);
	
}
