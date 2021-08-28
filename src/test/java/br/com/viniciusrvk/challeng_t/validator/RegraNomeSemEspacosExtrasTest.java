package br.com.viniciusrvk.challeng_t.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RegraNomeSemEspacosExtrasTest {

	private final RegraNomeSemEspacosExtras regraNomeSemEspacosExtras = new RegraNomeSemEspacosExtras();

	@Test
	public void deveRetornarResultdoTrue() {
		final String nome = "José da silva";
		assertTrue(regraNomeSemEspacosExtras.isValid(nome));
	}

	@Test
	public void deveRetornarResultdoFalseParaEspacoInicio() {
		final String nome = " José da silva";
		assertFalse(regraNomeSemEspacosExtras.isValid(nome));
	}

	@Test
	public void deveRetornarResultdoFalseParaEspacoFinal() {
		final String nome = "José da silva ";
		assertFalse(regraNomeSemEspacosExtras.isValid(nome));
	}

}
