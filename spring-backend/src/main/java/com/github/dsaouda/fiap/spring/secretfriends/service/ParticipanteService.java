package com.github.dsaouda.fiap.spring.secretfriends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;
import com.github.dsaouda.fiap.spring.secretfriends.model.Participante;
import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;
import com.github.dsaouda.fiap.spring.secretfriends.repository.GrupoRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.ParticipanteRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.UsuarioRepository;

@Service
public class ParticipanteService {

	@Autowired
	ParticipanteRepository participanteRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	GrupoRepository grupoRepository;

	public Participante participar(String usuarioUuid, String grupoUUid) {
		Usuario usuario = usuarioRepository.findByUuid(usuarioUuid);
		Grupo grupo = grupoRepository.findByUuid(grupoUUid);		
		
		return participanteRepository.save(new Participante(usuario, grupo));
	}

	public Iterable<Participante> participacoes(Usuario usuario) {
		return participanteRepository.findByParticipante(usuario);
	}
}
