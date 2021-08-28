package br.com.viniciusrvk.challeng_t.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.viniciusrvk.challeng_t.domain.Gerente;

@RunWith(SpringRunner.class)
public class GerenteValidadorTest {

	@InjectMocks
	private GerenteValidador gerenteValidador;

	@Mock
	private List<Rule> rules;

	private final Rule rule = mock(Rule.class);

	@Test
	public void deveRetornarNomeValido() {
		final String nome = "Jose da Silva";
		final Gerente gerente = new Gerente(nome);
		when(rule.isValid(nome)).thenReturn(true);
		assertThat(gerenteValidador.validar(gerente).getResultado()).isTrue();
	}
}
