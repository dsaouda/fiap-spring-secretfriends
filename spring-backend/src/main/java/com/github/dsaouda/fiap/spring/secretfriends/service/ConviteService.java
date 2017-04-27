package com.github.dsaouda.fiap.spring.secretfriends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dsaouda.fiap.spring.secretfriends.model.Convite;
import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;
import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;
import com.github.dsaouda.fiap.spring.secretfriends.repository.ConviteRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.GrupoRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.UsuarioRepository;

@Service
public class ConviteService {

	@Autowired
	GrupoRepository grupoRepository;

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ConviteRepository conviteRepository;
	
	public Convite convidar(String grupoUuid, String usuarioDeUuid, String usuarioParaUuid) {
		Grupo grupo = grupoRepository.findByUuid(grupoUuid);
		Usuario de = usuarioRepository.findByUuid(usuarioDeUuid);
		Usuario para = usuarioRepository.findByUuid(usuarioParaUuid);
		
		return conviteRepository.save(new Convite(de, para, grupo));
	}
	
}
