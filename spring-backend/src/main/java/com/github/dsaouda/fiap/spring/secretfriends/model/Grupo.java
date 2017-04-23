package com.github.dsaouda.fiap.spring.secretfriends.model;

import java.math.BigDecimal;
import java.util.Date;

public class Grupo {
	
	private String uuid;
	private String nome;
	private String tipoGrupo;
	private Date dataSorteio;
	private BigDecimal valorPresente;
	private String localEvento;
	private Date dataEvento;
	private String observacoes;
	private Usuario administrador;
}
