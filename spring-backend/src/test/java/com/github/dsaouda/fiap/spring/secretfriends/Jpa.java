package com.github.dsaouda.fiap.spring.secretfriends;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
/*
import com.github.dsaouda.fiap.spring.secretfriends.dao.ConviteDao;
import com.github.dsaouda.fiap.spring.secretfriends.dao.GrupoDao;
import com.github.dsaouda.fiap.spring.secretfriends.dao.ParticipanteDao;
import com.github.dsaouda.fiap.spring.secretfriends.dao.UsuarioDao;
import com.github.dsaouda.fiap.spring.secretfriends.factory.JpaUtil;
import com.github.dsaouda.fiap.spring.secretfriends.model.Convite;
import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;
import com.github.dsaouda.fiap.spring.secretfriends.model.Participante;
import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;
*/

public class Jpa {
	
	public static void main(String[] args) {
		/*
		//SET FOREIGN_KEY_CHECKS=0;drop table Usuario; drop table Grupo; drop table Convite; drop table Participante;
		EntityManager em = JpaUtil.getEntityManager();
		
		UsuarioDao usuarioDao = new UsuarioDao(em);
		GrupoDao grupoDao = new GrupoDao(em);
		ConviteDao conviteDao = new ConviteDao(em);
		ParticipanteDao participanteDao = new ParticipanteDao(em);
		
		Usuario u1 = new Usuario("Diego Saouda", "diegosaouda@gmail.com", "dsaouda");
		Usuario u2 = new Usuario("Aline Saouda", "alinesaouda@gmail.com", "asaouda");
		Usuario u3 = new Usuario("João Saouda", "joaosaouda@gmail.com", "jsaouda");
		
		Grupo g = new Grupo("pascoa familia", "Casa", new Date(), new Date(), u1);
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		usuarioDao.salvar(u1);
		usuarioDao.salvar(u2);
		usuarioDao.salvar(u3);
		
		grupoDao.salvar(g);
		
		conviteDao.salvar(new Convite(u1, u2, g));
		conviteDao.salvar(new Convite(u1, u3, g));
		
		participanteDao.salvar(new Participante(u1, g));
		participanteDao.salvar(new Participante(u2, g));
		participanteDao.salvar(new Participante(u3, g));
		
		transaction.commit();
		*/
	}
	
}
