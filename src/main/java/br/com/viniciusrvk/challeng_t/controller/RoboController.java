package br.com.viniciusrvk.challeng_t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.viniciusrvk.challeng_t.business.RoboBusiness;
import br.com.viniciusrvk.challeng_t.domain.Robo;
import br.com.viniciusrvk.challeng_t.domain.RoboDto;

@Controller
@RequestMapping("/robos")
public class RoboController {

	@Autowired
	private RoboBusiness roboBusiness;

	@PostMapping
	public ResponseEntity<Robo> cadastrarRobo(@RequestBody RoboDto roboDto){
		final Robo robo = roboBusiness.cadastrar(new Robo(roboDto.getNome()));
		return ResponseEntity.ok(robo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RoboDto> buscarRobo(@PathVariable(name = "id") Integer id, @RequestParam(name = "nome_formato" , defaultValue = "FULL") String formatoNome ){
		final Robo robo = roboBusiness.buscar(id, formatoNome);
		final RoboDto roboDto = new RoboDto();
		roboDto.setNome(robo.getNome());
		return ResponseEntity.ok(roboDto);
	}
}
