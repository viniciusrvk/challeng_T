package br.com.viniciusrvk.challeng_t.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viniciusrvk.challeng_t.domain.Robo;
import br.com.viniciusrvk.challeng_t.repository.RoboRepository;

@Service
public class RoboService {

	@Autowired
	private RoboRepository roboRepository;

	public Robo cadastrar(Robo robo) {
		System.out.println("cadastrado");
		final Robo roboSalvo = roboRepository.save(robo);
		return roboSalvo;
	}

	public Optional<Robo> buscar(Integer id) {
		return roboRepository.findById(id);
	}

}
