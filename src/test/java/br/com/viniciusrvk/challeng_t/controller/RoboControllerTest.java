package br.com.viniciusrvk.challeng_t.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.viniciusrvk.challeng_t.business.RoboBusiness;
import br.com.viniciusrvk.challeng_t.domain.Robo;
import br.com.viniciusrvk.challeng_t.domain.RoboDto;

@RunWith(SpringRunner.class)
public class RoboControllerTest {

	@InjectMocks
	private RoboController controller;

	@Mock
	private RoboBusiness business;

	@Test
	public void deveRetornarCadastrado() {

		final RoboDto dto = new RoboDto();
		dto.setNome("José da Silva");
		final Robo robo = new Robo(dto.getNome());
		when(business.cadastrar(Mockito.any(Robo.class))).thenReturn(robo);

		final ResponseEntity<Robo> responseEntity = controller.cadastrarRobo(dto);

		final Robo roboCadastrado = responseEntity.getBody();

		assertThat(roboCadastrado.getNome()).isEqualTo(dto.getNome());
	}

}
