package com.github.dsaouda.fiap.spring.secretfriends.app.rest;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.github.dsaouda.fiap.spring.secretfriends.dto.GrupoDTO;
import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;
import com.github.dsaouda.fiap.spring.secretfriends.repository.GrupoRepository;
import com.github.dsaouda.fiap.spring.secretfriends.service.GrupoService;

@Transactional
@RestController
@RequestMapping("/api/rest/v1/grupo")
public class GrupoController {

	@Autowired
	GrupoRepository repository;
	
	@Autowired
	GrupoService service;
	
	@GetMapping("/{uuid}")
	public ResponseEntity<Grupo> get(@PathVariable("uuid") String uuid) {		
		Grupo grupo = repository.findByUuid(uuid);		
		return new ResponseEntity<Grupo>(grupo, HttpStatus.OK);
	}
	
	@GetMapping
	public List<GrupoDTO> getAll() {
		return service.getAll();
	}
	
	@PostMapping
	public ResponseEntity<Grupo> criar(@RequestBody Grupo grupo) {
		repository.save(grupo);
		return new ResponseEntity<Grupo>(grupo, HttpStatus.CREATED);
	}
	
	@PutMapping("/{uuid}")
	public Grupo update(@PathVariable String uuid, @RequestBody Grupo novoGrupo) {
		Grupo grupoAntigo = repository.findByUuid(uuid);
		
		novoGrupo.setId(grupoAntigo.getId());
		novoGrupo.setUuid(grupoAntigo.getUuid());
		
		repository.save(novoGrupo);
		
		return novoGrupo;
	}
	
	@PatchMapping("/{uuid}")
	public Grupo updateParcial(@PathVariable String uuid, @RequestBody Grupo novosDados) {
		Grupo grupo = repository.findByUuid(uuid);
		
		if (novosDados.getNome() != null && !novosDados.getNome().trim().isEmpty()) {
			grupo.setNome(novosDados.getNome());
		}
		
		
		return repository.save(grupo);
	}
	
	@DeleteMapping("/{uuid}")
	public ResponseEntity<Object> delete(@PathVariable String uuid) {
		repository.deleteByUuid(uuid);
		return new ResponseEntity<Object>(new Object(), HttpStatus.OK);
	}
	
}
