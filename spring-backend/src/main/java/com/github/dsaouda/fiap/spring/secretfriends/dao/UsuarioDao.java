package com.github.dsaouda.fiap.spring.secretfriends.dao;

import javax.persistence.EntityManager;

import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;

public class UsuarioDao extends AbstractDao<Usuario, Long>{

	public UsuarioDao(EntityManager em) {
		super(em, Usuario.class);
	}
	
}
