package com.github.dsaouda.fiap.spring.secretfriends.dao;

import javax.persistence.EntityManager;

import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;

public class GrupoDao extends AbstractDao<Grupo, Long>{

	public GrupoDao(EntityManager em) {
		super(em, Grupo.class);
	}
	
}
