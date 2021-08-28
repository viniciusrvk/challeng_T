package br.com.viniciusrvk.challeng_t.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RegraNomeNaoVazioTest {

	private final RegraNomeNaoVazio regraNomeNaoVazio = new RegraNomeNaoVazio();

	@Test
	public void deveRetornarResultdoTrue() {
		final String nome = "José da silva";
		assertTrue(regraNomeNaoVazio.isValid(nome));
	}

	@Test
	public void deveRetornarResultdoFalse() {
		final String nome = "";
		assertFalse(regraNomeNaoVazio.isValid(nome));
	}

}
