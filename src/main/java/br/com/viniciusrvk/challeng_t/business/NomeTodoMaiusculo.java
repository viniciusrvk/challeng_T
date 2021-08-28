package br.com.viniciusrvk.challeng_t.business;

import org.springframework.stereotype.Component;

@Component
public class NomeTodoMaiusculo implements Formatter{

	@Override
	public String formatar(String atual) {
		return atual.toUpperCase();
	}

	@Override
	public String propriedade() {
		return "maiusculo";
	}

}
