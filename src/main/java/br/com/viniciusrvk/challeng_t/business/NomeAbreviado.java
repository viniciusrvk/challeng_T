package br.com.viniciusrvk.challeng_t.business;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class NomeAbreviado implements Formatter{

	@Override
	public String formatar(String atual) {
		final List<String> nomeSeparado = Arrays.asList(atual.split(" "));
		String formatado = "";
		for (Integer i = 0; i < nomeSeparado.size(); i++) {
			final String nomeAtual = nomeSeparado.get(i);
			if (i != 0 && i != nomeSeparado.size() - 1) {
				final String abreviado = " " + nomeAtual.substring(0, 1).toUpperCase() + ". ";
				formatado = formatado.concat(abreviado);
			} else {
				formatado = formatado.concat(nomeAtual);
			}
		}
		return formatado;
	}

	@Override
	public String propriedade() {
		return "abreviado";
	}

}
