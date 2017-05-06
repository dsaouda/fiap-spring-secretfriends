package com.github.dsaouda.fiap.spring.secretfriends.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dsaouda.fiap.spring.secretfriends.model.Convite;
import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;
import com.github.dsaouda.fiap.spring.secretfriends.model.Participante;
import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;
import com.github.dsaouda.fiap.spring.secretfriends.repository.ConviteRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.GrupoRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.ParticipanteRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.UsuarioRepository;

@Transactional
@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private ConviteRepository conviteRepository;
	
	public Participante participar(String usuarioUuid, String grupoUUid) {
		Usuario usuario = usuarioRepository.findByUuid(usuarioUuid);
		Grupo grupo = grupoRepository.findByUuid(grupoUUid);		
		
		Convite convite = conviteRepository.findByParaAndGrupo(usuario, grupo);
		convite.setAceitoEm(new Date());
		conviteRepository.save(convite);
		
		return participanteRepository.save(new Participante(usuario, grupo));
	}
	
	public Iterable<Participante> participacoes(Usuario usuario) {
		return participanteRepository.findByParticipante(usuario);
	}
}
