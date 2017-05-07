package com.github.dsaouda.fiap.spring.secretfriends.dto;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.github.dsaouda.fiap.spring.secretfriends.model.Convite;

public class ConviteEnviadoDTO {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private Convite convite;

	public ConviteEnviadoDTO(Convite convite) {
		this.convite = convite;
	}
	
	public static List<ConviteEnviadoDTO> toDTO(Iterable<Convite> convites) {
		return StreamSupport.stream(convites.spliterator(), false)
        	.map((e) -> new ConviteEnviadoDTO(e))
        	.collect(Collectors.toList());
	}
	
	public String getPara() {
		return convite.getPara().getNome();
	}
	
	public String getEmail() {
		return convite.getPara().getEmail();
	}
	
	public String getEm() {		
		return formatter.format(convite.getCriadoEm());
	}
	
	public String getAceitoEm() {		
		if (convite.getAceitoEm() != null) { 
			return formatter.format(convite.getAceitoEm());
		}
		
		return "";
	}
	
	public String getCanceladoEm() {
		if (convite.getCanceladoEm() != null) {
			return formatter.format(convite.getCanceladoEm());
		}
		return "";
	}
}
