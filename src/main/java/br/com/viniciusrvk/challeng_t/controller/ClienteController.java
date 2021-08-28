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

import br.com.viniciusrvk.challeng_t.business.ClienteBusiness;
import br.com.viniciusrvk.challeng_t.domain.Cliente;
import br.com.viniciusrvk.challeng_t.domain.ClienteDto;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteBusiness clienteBusiness;

	@PostMapping
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody ClienteDto clienteDto){
		final Cliente cliente = clienteBusiness.cadastrar(new Cliente(clienteDto.getNome()));
		return ResponseEntity.ok(cliente);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<ClienteDto> buscarCliente(@PathVariable(name = "id") Integer id, @RequestParam(name = "nome_formato" , defaultValue = "completo") String formatoNome ){
		final Cliente cliente = clienteBusiness.buscar(id, formatoNome);
		final ClienteDto clienteDto = new ClienteDto();
		clienteDto.setNome(cliente.getNome());
		return ResponseEntity.ok(clienteDto);
	}
}
