package com.github.dsaouda.fiap.spring.secretfriends.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.github.dsaouda.fiap.spring.secretfriends.model.Usuario;

@SessionScope
@Component
public class UsuarioSession {

	private Usuario usuario;
	
	@Deprecated
	protected UsuarioSession() {}
	
	public UsuarioSession(Usuario usuario) {
		fill(usuario);
	}

	public Long getId() {
		if (usuario == null) return null;
		return usuario.getId();
	}
	
	public String getUuid() {
		if (usuario == null) return null;
		return usuario.getUuid();
	}
	
	public String getNome() {
		if (usuario == null) return null;
		return usuario.getNome();
	}
	
	public String getEmail() {
		if (usuario == null) return null;
		return usuario.getEmail();
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void fill(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void remove() {
		this.usuario = null;
	}
	
	@Override
	public String toString() {
		return "UsuarioSession [id=" + getId() + ", uuid=" + getUuid() + ", nome=" + getNome() + ", email=" + getEmail() + "]";
	}
}
