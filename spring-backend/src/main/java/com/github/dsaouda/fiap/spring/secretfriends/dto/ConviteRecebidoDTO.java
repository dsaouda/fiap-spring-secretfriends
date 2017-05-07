package com.github.dsaouda.fiap.spring.secretfriends.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.github.dsaouda.fiap.spring.secretfriends.model.Convite;
import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;

public class ConviteRecebidoDTO {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	private String de;
	private String email;
	private String recebidoEm;
	private String grupo;
	private String grupoUid;
	private String aceitoEm;
	private String canceladoEm;
	private String dataEvento;
	private String dataSorteio;
	private boolean isSorteioRealizado;
	private boolean isEventoJaOcorreu;

	public ConviteRecebidoDTO(Convite convite) {
		de = convite.getDe().getNome();
		email = convite.getDe().getEmail();
		recebidoEm = formatter.format(convite.getCriadoEm());
		
		aceitoEm = convite.getAceitoEm() != null ? formatter.format(convite.getAceitoEm()) : "";
		canceladoEm = convite.getCanceladoEm() != null ? formatter.format(convite.getCanceladoEm()) : "";
		
		Grupo grupoInfo = convite.getGrupo();
		
		dataEvento = formatter.format(grupoInfo.getDataEvento());
		dataSorteio = formatter.format(grupoInfo.getDataSorteio());
		isSorteioRealizado = grupoInfo.getDataSorteio().compareTo(new Date()) <= 0;
		isEventoJaOcorreu = grupoInfo.getDataEvento().compareTo(new Date()) <= 0;
		grupo = grupoInfo.getNome();
		grupoUid = grupoInfo.getUuid();
	}
	
	public static List<ConviteRecebidoDTO> toDTO(Iterable<Convite> convites) {
		return StreamSupport.stream(convites.spliterator(), false)
        	.map((e) -> new ConviteRecebidoDTO(e))
        	.collect(Collectors.toList());
	}

	public String getDe() {
		return de;
	}

	public String getEmail() {
		return email;
	}

	public String getRecebido() {
		return recebidoEm;
	}

	public String getGrupo() {
		return grupo;
	}

	public String getGrupoUid() {
		return grupoUid;
	}

	public String getAceitoEm() {
		return aceitoEm;
	}

	public String getCanceladoEm() {
		return canceladoEm;
	}

	public String getDataEvento() {
		return dataEvento;
	}

	public String getDataSorteio() {
		return dataSorteio;
	}

	public boolean isSorteioRealizado() {
		return isSorteioRealizado;
	}

	public boolean isEventoJaOcorreu() {
		return isEventoJaOcorreu;
	}	
}
