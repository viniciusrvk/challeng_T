package br.com.viniciusrvk.challeng_t.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.viniciusrvk.challeng_t.domain.Robo;
import br.com.viniciusrvk.challeng_t.service.RoboService;
import br.com.viniciusrvk.challeng_t.validator.RoboValidador;

@Component
public class RoboBusiness {

	private final RoboService roboService;
	private final RoboValidador roboValidador;
	private final NomeFormatter nomeFormatter;

	@Autowired
	public RoboBusiness(RoboValidador roboValidador, RoboService roboService,
			NomeFormatter nomeFormatter) {
		this.roboService = roboService;
		this.roboValidador = roboValidador;
		this.nomeFormatter = nomeFormatter;
	}

	public Robo cadastrar(Robo robo) {
		if (roboValidador.validar(robo).getResultado()) {
			roboService.cadastrar(robo);
		}
		return robo;
	}

	public Robo buscar(final Integer id, final String formatoNome) {
		final Robo robo = roboService.buscar(id).get();
		final String nomeFormatado = nomeFormatter.aplicarFormatador(robo.getNome(), formatoNome);
		robo.setNome(nomeFormatado);
		return robo;
	}

}
