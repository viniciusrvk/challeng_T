package br.com.viniciusrvk.challeng_t.domain;

import java.io.Serializable;

public class ClienteDto implements Serializable {

	private static final long serialVersionUID = 270886927005447167L;

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
