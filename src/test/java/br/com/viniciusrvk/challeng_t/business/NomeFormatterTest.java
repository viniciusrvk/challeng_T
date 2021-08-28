package br.com.viniciusrvk.challeng_t.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class NomeFormatterTest {

	private NomeFormatter nomeFormatter;

	@Test
	public void deveRetornarVerdadeiro() {
		nomeFormatter = new NomeFormatter(Arrays.asList(new NomeCompleto()));
		final String formatador = "completo";
		final String nome = "Jose Silva Soares";
		final String nomeFormatado = nomeFormatter.aplicarFormatador(nome, formatador);
		assertThat(nomeFormatado).isEqualTo(nome);
	}

}
