package br.com.viniciusrvk.challeng_t.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class NomeCompletoTest {

	private final NomeCompleto formatador = new NomeCompleto();

	@Test
	public void deveRetornarNomeCompleto() {
		final String atual = formatador.formatar("Jose Carlos Silva");
		assertThat(atual).isEqualTo("Jose Carlos Silva");
	}

}
