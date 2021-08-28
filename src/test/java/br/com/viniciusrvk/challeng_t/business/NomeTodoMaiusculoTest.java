package br.com.viniciusrvk.challeng_t.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class NomeTodoMaiusculoTest {

	private final NomeTodoMaiusculo nomeTodoMaiusculo = new NomeTodoMaiusculo();

	@Test
	public void deveRetornarNomeTodoMaiusculo() {
		final String nome = "Jose Silva";
		assertThat(nomeTodoMaiusculo.formatar(nome)).isEqualTo("JOSE SILVA");
	}

}
