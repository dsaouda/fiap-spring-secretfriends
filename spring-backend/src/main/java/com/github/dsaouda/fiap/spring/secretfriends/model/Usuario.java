package com.github.dsaouda.fiap.spring.secretfriends.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.mindrot.jbcrypt.BCrypt;

@Entity
public class Usuario extends AbstractModel {
	
	@NotNull
	@NotEmpty
	@Size(min = 4, message="valor precisa ter no mínimo 4 caracteres")
	@Column(nullable=false)
	private String nome;
	
	@NotNull
	@NotEmpty
	@Email(message="não é um e-mail válido")
	@Column(unique=true, nullable=false)
	private String email;
	
	@NotNull
	@Column(nullable=false)
	private String senha;
	
	@Transient
	@NotEmpty
	@Size(min=4, message="Senha precisa ter no mínimo {min} caracteres")
	private String plainSenha;
	
	@Deprecated //jpa
	protected Usuario() {}
	
	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		setSenha(senha);
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
		this.plainSenha = senha;
		
		if (senha != null && !senha.isEmpty()) {
			String hashed = BCrypt.hashpw(senha, BCrypt.gensalt(12));
		
			this.senha = hashed;
		}
	}
	
	public boolean confirmarSenha(String plainSenha) {
		return BCrypt.checkpw(plainSenha, senha);
	}
}
