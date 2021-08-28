package br.com.viniciusrvk.challeng_t.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RegraNomeNaoNuloTest {

	private final RegraNomeNaoNulo regraNomeNaoNulo = new RegraNomeNaoNulo();

	@Test
	public void deveRetornarResultdoTrue() {
		final String nome = "José da silva";
		assertTrue(regraNomeNaoNulo.isValid(nome));
	}

	@Test
	public void deveRetornarResultdoFalse() {
		final String nome = null;
		assertFalse(regraNomeNaoNulo.isValid(nome));
	}

}
