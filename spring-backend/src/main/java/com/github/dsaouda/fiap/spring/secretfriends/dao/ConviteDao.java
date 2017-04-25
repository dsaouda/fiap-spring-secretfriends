package com.github.dsaouda.fiap.spring.secretfriends.dao;

import javax.persistence.EntityManager;

import com.github.dsaouda.fiap.spring.secretfriends.model.Convite;

public class ConviteDao extends AbstractDao<Convite, Long>{

	public ConviteDao(EntityManager em) {
		super(em, Convite.class);
	}
	
}
