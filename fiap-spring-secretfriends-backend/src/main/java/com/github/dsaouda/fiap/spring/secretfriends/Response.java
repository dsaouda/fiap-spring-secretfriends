package com.github.dsaouda.fiap.spring.secretfriends;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class Response {
	
	@XmlElement(name="amigo")
	private Amigo amigo;
	
	protected Response() {}
	
	public Response(Amigo amigo) {
		this.amigo = amigo;
	}
	
	public void setValor(Amigo amigo) {
		this.amigo = amigo;
	}

	public Amigo getAmigo() {
		return amigo;
	}
}
