package com.github.dsaouda.fiap.spring.secretfriends.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@MappedSuperclass
abstract class AbstractModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected long id;	
	
	@NotNull
	@Column(nullable=false, unique=true)
	protected String uuid;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date criadoEm;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date alteradoEm;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public Date getCriadoEm() {
		return criadoEm;
	}

	public Date getAlteradoEm() {
		return alteradoEm;
	}

	@PrePersist
	private void preInsert() {
		uuid = UUID.randomUUID().toString();
		criadoEm = new Date();
		alteradoEm = new Date();
	}
	
	@PreUpdate
	private void preUpdate() {
		criadoEm = new Date();
		alteradoEm = new Date();
	}
}
