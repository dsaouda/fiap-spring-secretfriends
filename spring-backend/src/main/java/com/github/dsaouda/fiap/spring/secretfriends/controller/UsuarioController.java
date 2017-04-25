package com.github.dsaouda.fiap.spring.secretfriends.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dsaouda.fiap.spring.secretfriends.dao.UsuarioDao;
import com.github.dsaouda.fiap.spring.secretfriends.factory.JpaUtil;
import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

	@GetMapping("/{uuid}")
	public ResponseEntity<Usuario> get(@PathVariable("uuid") String uuid) {
		EntityManager em = JpaUtil.getEntityManager();
		
		UsuarioDao dao = new UsuarioDao(em);
		Usuario usuario = dao.buscarPorUUID(uuid);
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@GetMapping
	public List<Usuario> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		UsuarioDao dao = new UsuarioDao(em);
		List<Usuario> usuarios = dao.getList();
		return usuarios;
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		UsuarioDao dao = new UsuarioDao(em);
		dao.salvar(usuario);
		transaction.commit();
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
	}
	
	@PutMapping("/{uuid}")
	public Usuario update(@PathVariable String uuid, @RequestBody Usuario novoUsuario) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		UsuarioDao dao = new UsuarioDao(em);
		Usuario usuarioAntigo = dao.buscarPorUUID(uuid);
		
		novoUsuario.setId(usuarioAntigo.getId());
		novoUsuario.setUuid(usuarioAntigo.getUuid());
		
		dao.merge(novoUsuario);
		transaction.commit();
		
		
		return novoUsuario;
	}
	
	@PatchMapping("/{uuid}")
	public Usuario updateParcial(@PathVariable String uuid, @RequestBody Usuario novosDados) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		UsuarioDao dao = new UsuarioDao(em);
		Usuario usuario = dao.buscarPorUUID(uuid);
		
		if (novosDados.getNome() != null && !novosDados.getNome().trim().isEmpty()) {
			usuario.setNome(novosDados.getNome());
		}
		
		if (novosDados.getSenha() != null && !novosDados.getSenha().trim().isEmpty()) {
			usuario.setSenha(novosDados.getSenha());
		}
		
		dao.salvar(usuario);
		transaction.commit();
		
		
		return usuario;
	}
	
	@DeleteMapping("/{uuid}")
	public ResponseEntity<Object> delete(@PathVariable String uuid) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		UsuarioDao dao = new UsuarioDao(em);
		Usuario usuario = dao.buscarPorUUID(uuid);
		
		dao.delete(usuario);
		transaction.commit();
		
		return new ResponseEntity<Object>(new Object(), HttpStatus.OK);
	}
	
}
