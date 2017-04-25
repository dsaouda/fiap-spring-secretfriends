package com.github.dsaouda.fiap.spring.secretfriends.dao;

import javax.persistence.EntityManager;

import com.github.dsaouda.fiap.spring.secretfriends.model.Participante;

public class ParticipanteDao extends AbstractDao<Participante, Long>{

	public ParticipanteDao(EntityManager em) {
		super(em, Participante.class);
	}
	
}
