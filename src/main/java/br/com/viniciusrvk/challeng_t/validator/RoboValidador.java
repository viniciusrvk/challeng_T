package br.com.viniciusrvk.challeng_t.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.viniciusrvk.challeng_t.domain.Robo;

@Component
public class RoboValidador implements Validador<Robo>{

	private final List<Rule> validatores;

	private Boolean resultado;

	@Autowired
	public RoboValidador(List<Rule> validadores) {
		this.validatores = validadores;
	}

	@Override
	public RoboValidador validar(Robo cliente) {
		this.resultado =  validatores.stream().allMatch(validator -> validator.isValid(cliente.getNome()));
		return this;
	}

	public Boolean getResultado() {
		return this.resultado;
	}



}
