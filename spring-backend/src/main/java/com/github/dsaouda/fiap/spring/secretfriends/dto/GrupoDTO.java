package com.github.dsaouda.fiap.spring.secretfriends.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;

public class GrupoDTO {
	private Grupo grupo;
	
	public GrupoDTO(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public static List<GrupoDTO> toDTO(Iterable<Grupo> grupos) {
		return StreamSupport.stream(grupos.spliterator(), false)
        	.map((g) -> new GrupoDTO(g))
        	.collect(Collectors.toList());
	}
	
	public String getUuid() {
		return grupo.getUuid();
	}
	
	public String getNome() {
		return grupo.getNome();
	}

	public BigDecimal getValorPresente() {
		return grupo.getValorPresente();
	}

	public String getLocalEvento() {
		return grupo.getLocalEvento();
	}

	@JsonFormat(pattern="dd/MM/yyyy HH:mm", timezone="America/Sao_Paulo")
	public Date getDataSorteio() {
		return grupo.getDataSorteio();
	}

	@JsonFormat(pattern="dd/MM/yyyy HH:mm", timezone="America/Sao_Paulo")
	public Date getDataEvento() {
		return grupo.getDataEvento();
	}
	
	public boolean isEventoOcorreu() {
		return grupo.getDataEvento().compareTo(new Date()) <= 0 ? true : false;
	}
	
	public String getStatus() {
		return grupo.getStatus().name();
	}

	public String getObservacoes() {
		return grupo.getObservacoes();
	}

	public Map<String, String> getAdministrador() {
		HashMap<String, String> usuario = new HashMap<>();
		usuario.put("uuid", grupo.getAdministrador().getUuid());
		usuario.put("nome", grupo.getAdministrador().getNome());
		
		return usuario;
	}
	


}
