package com.github.dsaouda.fiap.spring.secretfriends.app.rpc.v1;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;
import com.github.dsaouda.fiap.spring.secretfriends.repository.UsuarioRepository;
import com.github.dsaouda.fiap.spring.secretfriends.request.Request;
import com.github.dsaouda.fiap.spring.secretfriends.response.Response;
import com.github.dsaouda.fiap.spring.secretfriends.session.UsuarioSession;
import com.github.dsaouda.fiap.spring.secretfriends.validator.SimpleValidation;

@Transactional
@RestController
@RequestMapping("/open/rpc/v1/login")
public class LoginController {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired 
	private UsuarioSession usuarioSession;
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> login(@RequestBody Request request) {
		Usuario usuario = repository.findByEmail(request.getString("email"));
		
		if (usuario == null || !usuario.confirmarSenha(request.getString("senha"))) {
			return Response.badRequest(null).build("Usuário e/ou senha não são válidos");
		}
		
		usuarioSession.fill(usuario);
		return Response.ok(null).build();
	}
	
	@PostMapping("logout")
	public void logout() {
		usuarioSession.remove();
	}
	
	@PostMapping("cadastro")
	public ResponseEntity<?> cadastro(@RequestBody Usuario usuario) {
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
	
}
