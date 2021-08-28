package br.com.viniciusrvk.challeng_t.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.viniciusrvk.challeng_t.domain.Gerente;

@Component
public class GerenteValidador implements Validador<Gerente>{

	private final List<Rule> validatores;

	private Boolean resultado;

	@Autowired
	public GerenteValidador(List<Rule> validadores) {
		this.validatores = validadores;
	}

	@Override
	public GerenteValidador validar(Gerente cliente) {
		this.resultado =  validatores.stream().allMatch(validator -> validator.isValid(cliente.getNome()));
		return this;
	}

	public Boolean getResultado() {
		return this.resultado;
	}



}
