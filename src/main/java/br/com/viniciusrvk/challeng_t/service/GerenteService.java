package br.com.viniciusrvk.challeng_t.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viniciusrvk.challeng_t.domain.Gerente;
import br.com.viniciusrvk.challeng_t.repository.GerenteRepository;

@Service
public class GerenteService {

	@Autowired
	private GerenteRepository clienteRepository;

	public Gerente cadastrar(Gerente cliente) {
		System.out.println("cadastrado");
		final Gerente clienteSalvo = clienteRepository.save(cliente);
		return clienteSalvo;
	}

	public Optional<Gerente> buscar(Integer id) {
		return clienteRepository.findById(id);
	}
}
