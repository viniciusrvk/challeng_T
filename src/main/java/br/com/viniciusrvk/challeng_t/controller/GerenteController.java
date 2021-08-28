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

import br.com.viniciusrvk.challeng_t.business.GerenteBusiness;
import br.com.viniciusrvk.challeng_t.domain.Gerente;
import br.com.viniciusrvk.challeng_t.domain.GerenteDto;

@Controller
@RequestMapping("/gerentes")
public class GerenteController {

	@Autowired
	private GerenteBusiness gerenteBusiness;

	//post
	@PostMapping
	public ResponseEntity<Gerente> cadastrarGerente(@RequestBody GerenteDto gerenteDto){
		final Gerente gerente = gerenteBusiness.cadastrar(new Gerente(gerenteDto.getNome()));
		return ResponseEntity.ok(gerente);
	}

	//get
	@GetMapping("/{id}")
	public ResponseEntity<GerenteDto> buscarGerente(@PathVariable(name = "id") Integer id, @RequestParam(name = "nome_formato" , defaultValue = "FULL") String formatoNome ){
		final Gerente gerente = gerenteBusiness.buscar(id, formatoNome);
		final GerenteDto gerenteDto = new GerenteDto();
		gerenteDto.setNome(gerente.getNome());
		return ResponseEntity.ok(gerenteDto);
	}
}
