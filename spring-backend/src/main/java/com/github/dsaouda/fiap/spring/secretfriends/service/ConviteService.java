package com.github.dsaouda.fiap.spring.secretfriends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dsaouda.fiap.spring.secretfriends.model.Convite;
import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;
import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;
import com.github.dsaouda.fiap.spring.secretfriends.repository.ConviteRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.GrupoRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.UsuarioRepository;
import com.github.dsaouda.fiap.spring.secretfriends.session.UsuarioSession;

@Service
public class ConviteService {

	@Autowired
	GrupoRepository grupoRepository;

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ConviteRepository conviteRepository;
	
	@Autowired
	UsuarioSession usuarioSession;
	
	public Convite convidar(String grupoUid, String usuarioParaEmail) {
		Grupo grupo = grupoRepository.findByUuid(grupoUid);
		Usuario para = usuarioRepository.findByEmail(usuarioParaEmail);		
		return conviteRepository.save(new Convite(usuarioSession.getUsuario(), para, grupo));		
	}
	
}
