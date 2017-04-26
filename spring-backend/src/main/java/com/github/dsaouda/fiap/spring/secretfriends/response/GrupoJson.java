package com.github.dsaouda.fiap.spring.secretfriends.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;

public class GrupoJson {
	private Grupo grupo;
	
	public GrupoJson(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public static List<GrupoJson> convert(Iterable<Grupo> grupos) {
		List<GrupoJson> gruposJson = new ArrayList<>();
		
		grupos.forEach(g -> {
			gruposJson.add(new GrupoJson(g));
		});
		
		return gruposJson;
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

	public String getAdministrador() {
		return grupo.getAdministrador().getUuid();
	}
	
	public String getAdministradorNome() {
		return grupo.getAdministrador().getNome();
	}	
}
