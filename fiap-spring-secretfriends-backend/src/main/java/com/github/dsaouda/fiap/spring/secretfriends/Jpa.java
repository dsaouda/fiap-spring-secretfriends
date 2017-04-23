package com.github.dsaouda.fiap.spring.secretfriends;

import javax.persistence.EntityManager;

import com.github.dsaouda.fiap.spring.secretfriends.factory.JpaUtil;
import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;

public class Jpa {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(new Usuario("Diego Saouda", "diegosaouda@gmail.com", "123456"));
		em.getTransaction().commit();
		
	}
}
