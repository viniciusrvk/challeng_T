package br.com.viniciusrvk.challeng_t.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.viniciusrvk.challeng_t.domain.Gerente;
import br.com.viniciusrvk.challeng_t.repository.GerenteRepository;

class GerenteServiceTest {

	@InjectMocks
	private GerenteService service;

	@Mock
	private GerenteRepository repository;

	@Test
	void deveCadastrarCorretamente() {
		final Gerente gerente = new Gerente("Jose da silva");
		when(repository.save(gerente)).thenReturn(gerente);
		final Gerente atual = service.cadastrar(gerente);
		assertThat(atual).isEqualTo(gerente);
	}

	@Test(expected = Exception.class)
	void deveRetornarErro() {
		final Gerente gerente = new Gerente("Jose da silva");
		when(repository.save(gerente)).thenThrow(Exception.class);
		final Gerente atual = service.cadastrar(gerente);
		assertThat(atual).isEqualTo(gerente);
	}

}
