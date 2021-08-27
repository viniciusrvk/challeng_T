package br.com.viniciusrvk.challeng_t.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NomeValidador {

	private final List<Rule> validatores;

	private Boolean resultado;

	@Autowired
	public NomeValidador(List<Rule> validadores) {
		this.validatores = validadores;
	}

	public NomeValidador validar(String fullName) {
		this.resultado =  validatores.stream().allMatch(validator -> validator.isValid(fullName));
		return this;
	}

	public Boolean getResultado() {
		return this.resultado;
	}
}
