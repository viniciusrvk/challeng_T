package br.com.viniciusrvk.challeng_t.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.viniciusrvk.challeng_t.domain.Cliente;

@Component
public class ClienteValidador implements Validador<Cliente>{

	private final List<Rule> validatores;

	private Boolean resultado;

	@Autowired
	public ClienteValidador(List<Rule> validadores) {
		this.validatores = validadores;
	}

	@Override
	public ClienteValidador validar(Cliente cliente) {
		this.resultado =  validatores.stream().allMatch(validator -> validator.isValid(cliente.getNome()));
		System.out.println("validar");
		return this;
	}

	public Boolean getResultado() {
		return this.resultado;
	}



}
