package com.github.dsaouda.fiap.spring.secretfriends.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Grupo extends AbstractModel  {
	
	@NotNull
	@Size(min = 3)
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=true)
	private BigDecimal valorPresente;
	
	@NotNull
	@Column(nullable=false)
	private String localEvento;
	
	@NotNull
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone="America/Sao_Paulo")
	@Future(message="Valor precisa estar no futuro")
	private Date dataSorteio;
	
	@NotNull
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone="America/Sao_Paulo")
	@Future(message="Valor precisa estar no futuro")
	private Date dataEvento;
	
	@Column(nullable=true)
	private String observacoes;
	
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name="usuario", nullable=false)
	private Usuario administrador;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private GrupoStatusEnum status;
	
	//jpa
	protected Grupo() {
		this.status = GrupoStatusEnum.SORTEIO_NAO_REALIZADO;
	}
	
	public Grupo(String nome, String localEvento, Date dataSorteio, Date dataEvento, Usuario administrador) {
		super();
		
		this.nome = nome;
		this.localEvento = localEvento;
		this.dataSorteio = dataSorteio;
		this.dataEvento = dataEvento;
		this.administrador = administrador;
		this.status = GrupoStatusEnum.SORTEIO_NAO_REALIZADO;
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorPresente() {
		return valorPresente;
	}

	public void setValorPresente(BigDecimal valorPresente) {
		this.valorPresente = valorPresente;
	}

	public String getLocalEvento() {
		return localEvento;
	}

	public void setLocalEvento(String localEvento) {
		this.localEvento = localEvento;
	}

	public Date getDataSorteio() {
		return dataSorteio;
	}

	public void setDataSorteio(Date dataSorteio) {
		this.dataSorteio = dataSorteio;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Usuario getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}
	
	public GrupoStatusEnum getStatus() {
		return status;
	}

	public void setStatus(GrupoStatusEnum status) {
		this.status = status;
	}
	
	public boolean isEventoOcorreu() {
		return dataEvento.compareTo(new Date()) <= 0 ? true : false;
	}
	
	@AssertTrue(message="A data do evento tem que ser maior que a data do sorteio")
	public boolean isDataEventoMaiorQueDataSorteio() {
		return dataEvento.compareTo(dataSorteio) > 0;
	}
	
	@Override
	public String toString() {
		return "Grupo [nome=" + nome + ", valorPresente=" + valorPresente + ", localEvento=" + localEvento
				+ ", dataSorteio=" + dataSorteio + ", dataEvento=" + dataEvento + ", observacoes=" + observacoes + "]";
	}
}
