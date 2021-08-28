package br.com.viniciusrvk.challeng_t.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.viniciusrvk.challeng_t.domain.Gerente;
import br.com.viniciusrvk.challeng_t.service.GerenteService;
import br.com.viniciusrvk.challeng_t.validator.GerenteValidador;

@RunWith(SpringRunner.class)
public class GerenteBusinessTest {

	@InjectMocks
	private GerenteBusiness business;

	@Mock
	private GerenteService service;
	@Mock
	private GerenteValidador validador;
	@Mock
	private NomeFormatter formatter;

	@Test
	public void deveRetornarCadastrado() {
		final Gerente gerente = new Gerente("José da Silva");
		when(service.cadastrar(gerente)).thenReturn(gerente);
		when(validador.validar(gerente)).thenReturn(validador);
		when(validador.getResultado()).thenReturn(true);

		final Gerente cadastrado = business.cadastrar(gerente);

		assertThat(cadastrado).isEqualTo(gerente);
	}

}
