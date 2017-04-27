package com.github.dsaouda.fiap.spring.secretfriends.app.rest.v1;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dsaouda.fiap.spring.secretfriends.model.Convite;
import com.github.dsaouda.fiap.spring.secretfriends.repository.ConviteRepository;
import com.github.dsaouda.fiap.spring.secretfriends.service.ConviteService;

@Transactional
@RestController
@RequestMapping("/api/rest/v1/convite")
public class ConviteController {

	@Autowired
	ConviteRepository repository;
	
	@Autowired
	ConviteService service;
	
	@GetMapping("/{uuid}")
	public ResponseEntity<Convite> get(@PathVariable("uuid") String uuid) {		
		Convite convite = repository.findByUuid(uuid);		
		return new ResponseEntity<Convite>(convite, HttpStatus.OK);
	}
	
	@GetMapping
	public Iterable<Convite> getAll() {
		Iterable<Convite> convites = repository.findAll();
		return convites;
	}
	
	@PostMapping
	public ResponseEntity<Convite> convidar(@RequestBody Map<String, String> req) {
		//@todo remover hardcode
		Convite convite = service.convidar(req.get("grupo"), "dbb7657b-b08b-48ec-9cf2-008835b1c7de", req.get("usuario_convidado"));
		
		return new ResponseEntity<Convite>(convite, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{uuid}")
	public ResponseEntity<Object> delete(@PathVariable String uuid) {
		repository.deleteByUuid(uuid);
		return new ResponseEntity<Object>(new Object(), HttpStatus.OK);
	}
	
}
