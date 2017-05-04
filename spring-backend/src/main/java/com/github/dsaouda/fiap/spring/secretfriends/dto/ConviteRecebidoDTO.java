package com.github.dsaouda.fiap.spring.secretfriends.dto;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.github.dsaouda.fiap.spring.secretfriends.model.Convite;
import com.github.dsaouda.fiap.spring.secretfriends.model.Grupo;

public class ConviteRecebidoDTO {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	private String de;
	private String email;
	private String recebido;
	private String grupo;
	private String grupoUid;

	public ConviteRecebidoDTO(Convite convite) {
		de = convite.getDe().getNome();
		email = convite.getDe().getEmail();
		recebido = formatter.format(convite.getCriadoEm());
		
		Grupo grupoBusca = convite.getGrupo();
		System.out.println("\n\n");
		System.out.println("GRUPO: " + grupoBusca);
		System.out.println("\n\n");
		System.out.println("GRUPO UUID: " + grupoBusca.getUuid());
		System.out.println("\n\n");
		System.out.println("GRUPO ID: " + grupoBusca.getId());
		System.out.println("\n\n");
		System.out.println("GRUPO NOME: " + grupoBusca.getNome());
		System.out.println("\n\n");
		
		grupo = grupoBusca.getNome();
		grupoUid = grupoBusca.getUuid();
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
		return recebido;
	}

	public String getGrupo() {
		return grupo;
	}

	public String getGrupoUid() {
		return grupoUid;
	}
	
	
}
