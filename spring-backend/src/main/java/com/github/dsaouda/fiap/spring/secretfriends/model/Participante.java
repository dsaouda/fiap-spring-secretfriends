package com.github.dsaouda.fiap.spring.secretfriends.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={
	@UniqueConstraint(columnNames = {"participante", "grupo"})
})
public class Participante extends AbstractModel {
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name="participante", nullable=false)
	private Usuario participante;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=true)
	@JoinColumn(name="amigoSecreto", nullable=true)
	private Usuario amigoSecreto;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name="grupo", nullable=false)
	private Grupo grupo;
	
	@Deprecated
	protected Participante() {}
	
	public Participante(Usuario participante, Grupo grupo) {
		this.participante = participante;
		this.grupo = grupo;
	}

	public Usuario getParticipante() {
		return participante;
	}

	public Usuario getAmigoSecreto() {
		return amigoSecreto;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setAmigoSecreto(Usuario amigoSecreto) {
		this.amigoSecreto = amigoSecreto;
	}
}
