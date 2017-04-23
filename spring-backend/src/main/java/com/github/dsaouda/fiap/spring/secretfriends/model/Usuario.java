package com.github.dsaouda.fiap.spring.secretfriends.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Usuario {

	@Id
	private String uuid;
	
	@NotNull
	@Size(min = 6)
	@Column(nullable=false)
	private String nome;
	
	@NotNull
	@Email
	@Column(unique=true, nullable=false)
	private String email;
	
	@NotNull
	@Size(min = 6)
	@Column(nullable=false)
	private String senha;
	
	@Deprecated //jpa
	protected Usuario() {}
	
	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		
		uuid = UUID.randomUUID().toString();
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
