package br.com.viniciusrvk.challeng_t.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.viniciusrvk.challeng_t.domain.Cliente;
import br.com.viniciusrvk.challeng_t.service.ClienteService;
import br.com.viniciusrvk.challeng_t.validator.ClienteValidador;

@Component
public class ClienteBusiness {

	private final ClienteService clienteService;
	private final ClienteValidador clienteValidador;
	private final NomeFormatter nomeFormatter;

	@Autowired
	public ClienteBusiness(ClienteValidador clienteValidador, ClienteService clienteService,
			NomeFormatter nomeFormatter) {
		this.clienteService = clienteService;
		this.clienteValidador = clienteValidador;
		this.nomeFormatter = nomeFormatter;
	}

	public Cliente cadastrar(Cliente cliente) {
		System.out.println("business");
		if (clienteValidador.validar(cliente).getResultado()) {
			clienteService.cadastrar(cliente);
		}
		return cliente;
	}

	public Cliente buscar(final Integer id, final String formatoNome) {
		final Cliente cliente = clienteService.buscar(id).get();
		final String nomeFormatado = nomeFormatter.aplicarFormatador(cliente.getNome(), formatoNome);
		cliente.setNome(nomeFormatado);
		return cliente;
	}

}
