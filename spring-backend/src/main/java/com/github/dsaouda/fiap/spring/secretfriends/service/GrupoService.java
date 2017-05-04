package com.github.dsaouda.fiap.spring.secretfriends.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.dsaouda.fiap.spring.secretfriends.dto.GrupoDTO;
import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;
import com.github.dsaouda.fiap.spring.secretfriends.model.Participante;
import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;
import com.github.dsaouda.fiap.spring.secretfriends.repository.GrupoRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.ParticipanteRepository;
import com.github.dsaouda.fiap.spring.secretfriends.repository.UsuarioRepository;
import com.github.dsaouda.fiap.spring.secretfriends.response.Response;
import com.github.dsaouda.fiap.spring.secretfriends.validator.SimpleValidation;

@Service
public class GrupoService {

	@Autowired
	GrupoRepository repository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ParticipanteRepository participanteRepository;
	
	public List<GrupoDTO> getAll(Usuario usuario) {
		Iterable<Grupo> grupos = repository.findByAdministrador(usuario);
		return GrupoDTO.toDTO(grupos);
	}
	
	public ResponseEntity<?> criar(Grupo grupo, Usuario usuario) {
		grupo.setAdministrador(usuario);
		
		SimpleValidation<Grupo> validation = new SimpleValidation<>(grupo);
		if (validation.isValid()) {
			grupo = repository.save(grupo);
			participanteRepository.save(new Participante(usuario, grupo));
			return Response.created(grupo).build();
		}
		
		return Response.badRequest(validation.getErrors()).build();
	}
}
