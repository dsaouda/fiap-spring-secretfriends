package com.github.dsaouda.fiap.spring.secretfriends.app.rest.v1;

import java.util.Map;

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

import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;
import com.github.dsaouda.fiap.spring.secretfriends.repository.UsuarioRepository;
import com.github.dsaouda.fiap.spring.secretfriends.response.Response;
import com.github.dsaouda.fiap.spring.secretfriends.validator.SimpleValidation;

@Transactional
@RestController
@RequestMapping("/rest/v1/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@GetMapping("/{uuid}")
	public ResponseEntity<Usuario> get(@PathVariable("uuid") String uuid) {
		Usuario usuario = repository.findByUuid(uuid);		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> getAll() {
		return Response.ok(repository.findAll()).build();
	}

	@PostMapping
	public ResponseEntity<?> criar(@RequestBody Usuario usuario) {
		SimpleValidation<Usuario> validation = new SimpleValidation<>(usuario);

		if (repository.findByEmail(usuario.getEmail()) != null) {
			return Response.badRequest(null).build("Usuário já cadastrado!");
		}

		if (validation.isValid()) {
			usuario = repository.save(usuario);
			return Response.created(usuario).build();
		}

		return Response.badRequest(validation.getErrors()).build();		
	}

	@PutMapping("/{uuid}")
	public Usuario update(@PathVariable String uuid, @RequestBody Usuario novoUsuario) {
		Usuario usuarioAntigo = repository.findByUuid(uuid);

		novoUsuario.setId(usuarioAntigo.getId());
		novoUsuario.setUuid(usuarioAntigo.getUuid());

		repository.save(novoUsuario);

		return novoUsuario;
	}

	@PatchMapping("/{uuid}")
	public Usuario updateParcial(@PathVariable String uuid, @RequestBody Usuario novosDados) {
		Usuario usuario = repository.findByUuid(uuid);

		if (novosDados.getNome() != null && !novosDados.getNome().trim().isEmpty()) {
			usuario.setNome(novosDados.getNome());
		}

		if (novosDados.getSenha() != null && !novosDados.getSenha().trim().isEmpty()) {
			usuario.setSenha(novosDados.getSenha());
		}

		return repository.save(usuario);
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<Object> delete(@PathVariable String uuid) {
		repository.deleteByUuid(uuid);
		return new ResponseEntity<Object>(new Object(), HttpStatus.OK);
	}

}
