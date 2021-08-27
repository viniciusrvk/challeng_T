package br.com.viniciusrvk.challeng_t.validator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class NomeValidadorTest {

	private NomeValidador nomeValidador;


	@Test
	public void deveRetornarErroParaNomeNulo() {
		final List<Rule> regras = Arrays.asList(new RegraNomeNaoNulo());
		nomeValidador = new NomeValidador(regras);
		final String nome = null;
		assertThat(nomeValidador.validar(nome).getResultado()).isFalse();
	}

	@Test
	public void deveRetornarErroParaNomeNaoVazio() {
		final List<Rule> regras = Arrays.asList(new RegraNomeNaoVazio());
		nomeValidador = new NomeValidador(regras);
		final String nome = "";
		assertThat(nomeValidador.validar(nome).getResultado()).isFalse();
	}

	@Test
	public void deveRetornarErroParaNomeComecandoComEspacoInicial() {
		final List<Rule> regras = Arrays.asList(new RegraNomeSemEspacosExtras());
		nomeValidador = new NomeValidador(regras);
		final String nome = " Joao Kleber";
		assertThat(nomeValidador.validar(nome).getResultado()).isFalse();
	}

	@Test
	public void deveRetornarErroParaNomeComecandoComEspacoFinal() {
		final List<Rule> regras = Arrays.asList(new RegraNomeSemEspacosExtras());
		nomeValidador = new NomeValidador(regras);
		final String nome = "Joao Kleber ";
		assertThat(nomeValidador.validar(nome).getResultado()).isFalse();
	}

}
