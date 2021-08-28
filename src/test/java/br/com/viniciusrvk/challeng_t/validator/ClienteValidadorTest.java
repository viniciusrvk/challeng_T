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

import br.com.viniciusrvk.challeng_t.domain.Cliente;

@RunWith(SpringRunner.class)
public class ClienteValidadorTest {

	@InjectMocks
	private ClienteValidador clienteValidador;

	@Mock
	private List<Rule> rules;

	private final Rule rule = mock(Rule.class);

	@Test
	public void deveRetornarNomeValido() {
		final String nome = "Jose da Silva";
		final Cliente cliente = new Cliente(nome);
		when(rule.isValid(nome)).thenReturn(true);
		assertThat(clienteValidador.validar(cliente).getResultado()).isTrue();
	}
}
