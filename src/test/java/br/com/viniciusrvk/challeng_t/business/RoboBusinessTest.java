package br.com.viniciusrvk.challeng_t.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.viniciusrvk.challeng_t.domain.Robo;
import br.com.viniciusrvk.challeng_t.service.RoboService;
import br.com.viniciusrvk.challeng_t.validator.RoboValidador;

@RunWith(SpringRunner.class)
public class RoboBusinessTest {

	@InjectMocks
	private RoboBusiness business;

	@Mock
	private RoboService service;
	@Mock
	private RoboValidador validador;
	@Mock
	private NomeFormatter formatter;

	@Test
	public void deveRetornarCadastrado() {
		final Robo robo = new Robo("José da Silva");
		when(service.cadastrar(robo)).thenReturn(robo);
		when(validador.validar(robo)).thenReturn(validador);
		when(validador.getResultado()).thenReturn(true);

		final Robo cadastrado = business.cadastrar(robo);

		assertThat(cadastrado).isEqualTo(robo);
	}

}
