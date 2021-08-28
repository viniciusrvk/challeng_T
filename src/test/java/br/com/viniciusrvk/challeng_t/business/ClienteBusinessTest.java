package br.com.viniciusrvk.challeng_t.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.viniciusrvk.challeng_t.domain.Cliente;
import br.com.viniciusrvk.challeng_t.service.ClienteService;
import br.com.viniciusrvk.challeng_t.validator.ClienteValidador;

@RunWith(SpringRunner.class)
public class ClienteBusinessTest {

	@InjectMocks
	private ClienteBusiness business;

	@Mock
	private ClienteService service;
	@Mock
	private ClienteValidador validador;
	@Mock
	private NomeFormatter formatter;

	@Test
	public void deveRetornarCadastrado() {
		final Cliente cliente = new Cliente("José da Silva");
		when(service.cadastrar(cliente)).thenReturn(cliente);
		when(validador.validar(cliente)).thenReturn(validador);
		when(validador.getResultado()).thenReturn(true);

		final Cliente cadastrado = business.cadastrar(cliente);

		assertThat(cadastrado).isEqualTo(cliente);
	}

}
