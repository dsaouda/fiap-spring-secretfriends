package com.github.dsaouda.fiap.spring.secretfriends.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

	public Date getDataSorteio() {
		return grupo.getDataSorteio();
	}

	public Date getDataEvento() {
		return grupo.getDataEvento();
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
