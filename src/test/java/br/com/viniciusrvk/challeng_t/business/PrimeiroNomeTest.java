package br.com.viniciusrvk.challeng_t.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PrimeiroNomeTest {

	private final PrimeiroNome formatador = new PrimeiroNome();

	@Test
	public void deveRetornarPrimeiroNome() {
		final String nome = "Jose Silva";
		assertThat(formatador.formatar(nome)).isEqualTo("Jose");
	}

}
