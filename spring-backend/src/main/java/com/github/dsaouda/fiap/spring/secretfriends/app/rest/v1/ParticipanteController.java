package com.github.dsaouda.fiap.spring.secretfriends.app.rest.v1;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dsaouda.fiap.spring.secretfriends.model.Participante;
import com.github.dsaouda.fiap.spring.secretfriends.service.ParticipanteService;
import com.github.dsaouda.fiap.spring.secretfriends.session.UsuarioSession;

@CrossOrigin
@Transactional
@RestController
@RequestMapping("/rest/v1/participante")
public class ParticipanteController {

	@Autowired
	ParticipanteService service;
	
	@Autowired
	UsuarioSession usuarioSession;
	
	@PostMapping
	public Participante participar(@RequestBody Map<String, String> req) {
		String grupo = req.get("grupo");
				
		return service.participar(usuarioSession.getUuid(), grupo);
	}	
}
