package br.com.viniciusrvk.challeng_t.business;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class PrimeiroNome implements Formatter{

	@Override
	public String formatar(String atual) {
		return Arrays.asList(atual.split(" ")).get(0);
	}

	@Override
	public String propriedade() {
		return "primeiro";
	}

}
