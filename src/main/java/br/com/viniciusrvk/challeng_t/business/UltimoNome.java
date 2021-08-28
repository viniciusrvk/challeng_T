package br.com.viniciusrvk.challeng_t.business;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UltimoNome implements Formatter{

	@Override
	public String formatar(String atual) {
		final List<String> nomes = Arrays.asList(atual.split(" "));
		return nomes.get(nomes.size()-1);
	}

	@Override
	public String propriedade() {
		return "ultimo";
	}

}
