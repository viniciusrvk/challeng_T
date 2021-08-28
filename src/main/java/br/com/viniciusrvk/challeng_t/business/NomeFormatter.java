package br.com.viniciusrvk.challeng_t.business;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NomeFormatter {

	private final Map<String, Formatter> formatadores;

	@Autowired
	public NomeFormatter(List<Formatter> formatterList) {
		formatadores = formatterList.stream()
				.collect(Collectors.toMap(Formatter::propriedade, formatter -> formatter));
	}

	public String aplicarFormatador(String nome, String formato) {
		return formatadores.get(formato).formatar(nome);
	}

}
