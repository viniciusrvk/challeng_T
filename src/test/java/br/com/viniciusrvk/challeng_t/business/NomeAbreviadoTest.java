package br.com.viniciusrvk.challeng_t.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class NomeAbreviadoTest {

	private final NomeAbreviado formatador = new NomeAbreviado();

	@Test
	public void deveRetornarNomeAbreviado() {
		final String atual = formatador.formatar("Jose Carlos Silva");
		assertThat(atual).isEqualTo("Jose C. Silva");
	}

}
