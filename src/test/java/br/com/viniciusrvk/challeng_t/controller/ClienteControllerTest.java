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

import br.com.viniciusrvk.challeng_t.business.ClienteBusiness;
import br.com.viniciusrvk.challeng_t.domain.Cliente;
import br.com.viniciusrvk.challeng_t.domain.ClienteDto;


@RunWith(SpringRunner.class)
public class ClienteControllerTest {

	@InjectMocks
	private ClienteController controller;

	@Mock
	private ClienteBusiness business;

	@Test
	public void deveRetornarCadastrado() {

		final ClienteDto dto = new ClienteDto();
		dto.setNome("José da Silva");
		final Cliente cliente = new Cliente(dto.getNome());
		when(business.cadastrar(Mockito.any(Cliente.class))).thenReturn(cliente);

		final ResponseEntity<Cliente> responseEntity = controller.cadastrarCliente(dto);

		final Cliente clienteCadastrado = responseEntity.getBody();

		assertThat(clienteCadastrado.getNome()).isEqualTo(dto.getNome());
	}

}
