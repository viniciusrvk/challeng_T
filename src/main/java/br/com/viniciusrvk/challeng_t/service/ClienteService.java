package br.com.viniciusrvk.challeng_t.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viniciusrvk.challeng_t.domain.Cliente;
import br.com.viniciusrvk.challeng_t.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente cadastrar(Cliente cliente) {
		final Cliente clienteSalvo = clienteRepository.save(cliente);
		System.out.println(clienteSalvo);
		return clienteSalvo;
	}

	public Optional<Cliente> buscar(Integer id) {
		return clienteRepository.findById(id);
	}

}
