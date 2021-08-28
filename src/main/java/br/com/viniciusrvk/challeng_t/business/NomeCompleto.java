package br.com.viniciusrvk.challeng_t.business;

import org.springframework.stereotype.Component;

@Component
public class NomeCompleto implements Formatter{

	@Override
	public String formatar(String atual) {
		return atual;
	}

	@Override
	public String propriedade() {
		return "completo";
	}

}
