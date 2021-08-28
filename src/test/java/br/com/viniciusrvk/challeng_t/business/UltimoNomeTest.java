package br.com.viniciusrvk.challeng_t.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class UltimoNomeTest {

	private final UltimoNome formatador = new UltimoNome();

	@Test
	public void deveRetornarUltimoNome() {
		final String nome = "Jose Silva";
		assertThat(formatador.formatar(nome)).isEqualTo("Silva");
	}

}
