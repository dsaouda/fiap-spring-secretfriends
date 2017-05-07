package com.github.dsaouda.fiap.spring.secretfriends.app.rest.v1;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Transactional
@RestController
@RequestMapping("")
public class ConviteController {

	/*
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
	}*/
	
}
