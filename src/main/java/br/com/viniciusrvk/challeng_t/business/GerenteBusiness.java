package br.com.viniciusrvk.challeng_t.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.viniciusrvk.challeng_t.domain.Gerente;
import br.com.viniciusrvk.challeng_t.service.GerenteService;
import br.com.viniciusrvk.challeng_t.validator.GerenteValidador;

@Component
public class GerenteBusiness {

	private final GerenteService gerenteService;
	private final GerenteValidador gerenteValidador;
	private final NomeFormatter nomeFormatter;

	@Autowired
	public GerenteBusiness(GerenteValidador gerenteValidador, GerenteService gerenteService,
			NomeFormatter nomeFormatter) {
		this.gerenteService = gerenteService;
		this.gerenteValidador = gerenteValidador;
		this.nomeFormatter = nomeFormatter;
	}

	public Gerente cadastrar(Gerente gerente) {
		if (gerenteValidador.validar(gerente).getResultado()) {
			gerenteService.cadastrar(gerente);
		}
		return gerente;
	}

	public Gerente buscar(final Integer id, final String formatoNome) {
		final Gerente gerente = gerenteService.buscar(id).get();
		final String nomeFormatado = nomeFormatter.aplicarFormatador(gerente.getNome(), formatoNome);
		gerente.setNome(nomeFormatado);
		return gerente;
	}

}
