package com.github.dsaouda.fiap.spring.secretfriends.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dsaouda.fiap.spring.secretfriends.dto.GrupoDTO;
import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;
import com.github.dsaouda.fiap.spring.secretfriends.model.Participante;
import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;
import com.github.dsaouda.fiap.spring.secretfriends.repository.GrupoRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.ParticipanteRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.UsuarioRepository;

@Service
public class GrupoService {

	@Autowired
	GrupoRepository repository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ParticipanteRepository participanteRepository;
	
	public List<GrupoDTO> getAll() {
		Iterable<Grupo> grupos = repository.findAll();
		return GrupoDTO.toDTO(grupos);
	}
	
	public Grupo criar(Grupo grupo) {
		grupo = repository.save(grupo);
		Usuario usuario = usuarioRepository.findByUuid("usuario da sessao");		
		participanteRepository.save(new Participante(usuario, grupo));
		return grupo;
	}
}
