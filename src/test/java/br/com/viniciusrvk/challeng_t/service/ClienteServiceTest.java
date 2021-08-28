package br.com.viniciusrvk.challeng_t.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.viniciusrvk.challeng_t.domain.Cliente;
import br.com.viniciusrvk.challeng_t.repository.ClienteRepository;

@RunWith(SpringRunner.class)
class ClienteServiceTest {

	@InjectMocks
	private ClienteService service;

	@Mock
	private ClienteRepository repository;

	@Test
	void deveCadastrarCorretamente() {
		final Cliente cliente = new Cliente("Jose da silva");
		when(repository.save(cliente)).thenReturn(cliente);
		final Cliente atual = service.cadastrar(cliente);
		assertThat(atual).isEqualTo(cliente);
	}

	@Test(expected = Exception.class)
	void deveRetornarErro() {
		final Cliente cliente = new Cliente("Jose da silva");
		when(repository.save(cliente)).thenThrow(Exception.class);
		final Cliente atual = service.cadastrar(cliente);
		assertThat(atual).isEqualTo(cliente);
	}

}
