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

import br.com.viniciusrvk.challeng_t.business.GerenteBusiness;
import br.com.viniciusrvk.challeng_t.domain.Gerente;
import br.com.viniciusrvk.challeng_t.domain.GerenteDto;


@RunWith(SpringRunner.class)
public class GerenteControllerTest {

	@InjectMocks
	private GerenteController controller;

	@Mock
	private GerenteBusiness business;

	@Test
	public void deveRetornarCadastrado() {

		final GerenteDto dto = new GerenteDto();
		dto.setNome("José da Silva");
		final Gerente gerente = new Gerente(dto.getNome());
		when(business.cadastrar(Mockito.any(Gerente.class))).thenReturn(gerente);

		final ResponseEntity<Gerente> responseEntity = controller.cadastrarGerente(dto);

		final Gerente gerenteCadastrado = responseEntity.getBody();

		assertThat(gerenteCadastrado.getNome()).isEqualTo(dto.getNome());
	}

}
