package br.com.viniciusrvk.challeng_t.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.viniciusrvk.challeng_t.domain.Robo;
import br.com.viniciusrvk.challeng_t.repository.RoboRepository;

class RoboServiceTest {

	@InjectMocks
	private RoboService service;

	@Mock
	private RoboRepository repository;

	@Test
	void deveCadastrarCorretamente() {
		final Robo gerente = new Robo("Jose da silva");
		when(repository.save(gerente)).thenReturn(gerente);
		final Robo atual = service.cadastrar(gerente);
		assertThat(atual).isEqualTo(gerente);
	}

	@Test(expected = Exception.class)
	void deveRetornarErro() {
		final Robo gerente = new Robo("Jose da silva");
		when(repository.save(gerente)).thenThrow(Exception.class);
		final Robo atual = service.cadastrar(gerente);
		assertThat(atual).isEqualTo(gerente);
	}

}
