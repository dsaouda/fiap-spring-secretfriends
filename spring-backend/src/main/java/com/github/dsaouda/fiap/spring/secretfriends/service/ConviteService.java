package com.github.dsaouda.fiap.spring.secretfriends.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dsaouda.fiap.spring.secretfriends.dto.ConviteEnviadoDTO;
import com.github.dsaouda.fiap.spring.secretfriends.dto.ConviteRecebidoDTO;
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
	private GrupoRepository grupoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ConviteRepository conviteRepository;
	
	@Autowired
	private UsuarioSession usuarioSession;
	
	public Convite convidar(String grupoUid, String usuarioParaEmail) {
		Grupo grupo = grupoRepository.findByUuid(grupoUid);
		Usuario para = usuarioRepository.findByEmail(usuarioParaEmail);		
		return conviteRepository.save(new Convite(usuarioSession.getUsuario(), para, grupo));		
	}
	
	public List<ConviteEnviadoDTO> enviados(String grupoUid) {
		Grupo grupo = grupoRepository.findByUuid(grupoUid);
		Iterable<Convite> convites = conviteRepository.findByGrupo(grupo);
		return ConviteEnviadoDTO.toDTO(convites); 
	}

	public List<ConviteRecebidoDTO> recebidos(Usuario usuario) {		
		Iterable<Convite> convites = conviteRepository.findByPara(usuario);
		return ConviteRecebidoDTO.toDTO(convites);		
	}
	
	public void rejeitar(String usuarioUuid, String grupoUUid) {
		Usuario usuario = usuarioRepository.findByUuid(usuarioUuid);
		Grupo grupo = grupoRepository.findByUuid(grupoUUid);		
		
		Convite convite = conviteRepository.findByParaAndGrupo(usuario, grupo);
		convite.setCanceladoEm(new Date());
		conviteRepository.save(convite);
	}
}
