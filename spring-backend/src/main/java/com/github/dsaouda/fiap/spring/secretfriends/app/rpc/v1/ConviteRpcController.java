package com.github.dsaouda.fiap.spring.secretfriends.app.rpc.v1;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dsaouda.fiap.spring.secretfriends.model.Convite;
import com.github.dsaouda.fiap.spring.secretfriends.repository.ConviteRepository;
import com.github.dsaouda.fiap.spring.secretfriends.request.Request;
import com.github.dsaouda.fiap.spring.secretfriends.response.Response;
import com.github.dsaouda.fiap.spring.secretfriends.service.ConviteService;

@CrossOrigin
@Transactional
@RestController()
@RequestMapping("/rpc/v1/convite")
public class ConviteRpcController {

	@Autowired
	ConviteRepository repository;
	
	@Autowired
	ConviteService service;
	
	@PostMapping("/enviar")
	public ResponseEntity<?> convidar(@RequestBody Request request) {
		try {
			Convite convidar = service.convidar(
				request.getString("grupo"), 
				request.getString("email")
			);
			return Response.created(convidar).build("Convite enviado com sucesso");
		} catch (Exception e) {
			return Response.badRequest(e).build("N�o foi poss�vel realizar o convite");
		}		
	}
	
	/*
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
