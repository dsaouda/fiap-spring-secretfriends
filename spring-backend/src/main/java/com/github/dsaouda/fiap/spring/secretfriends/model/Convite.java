package com.github.dsaouda.fiap.spring.secretfriends.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.github.dsaouda.fiap.spring.secretfriends.exception.ConviteInvalidoException;

@Entity
@Table(uniqueConstraints={
	@UniqueConstraint(columnNames = {"de", "para", "grupo"})
})
public class Convite extends AbstractModel {
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name="de", nullable=false)
	private Usuario de;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name="para", nullable=false)
	private Usuario para;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name="grupo", nullable=false)
	private Grupo grupo;
	
	@Deprecated
	protected Convite() {}
	
	public Convite(Usuario de, Usuario para, Grupo grupo) {
		throwsIfEquals(de, para);
		
		this.de = de;
		this.para = para;
		this.grupo = grupo;
	}

	private void throwsIfEquals(Usuario de, Usuario para) {
		if (de.getId() == para.getId()) {
			throw new ConviteInvalidoException();
		}
	}

	public Usuario getDe() {
		return de;
	}

	public Usuario getPara() {
		return para;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	@Override
	public String toString() {
		return "Convite [de=" + de + ", para=" + para + ", grupo=" + grupo + "]";
	}
}
