package com.hotmart.suggest.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hotmart.suggest.api.controller.base.BaseController;
import com.hotmart.suggest.api.dto.ClienteDTO;
import com.hotmart.suggest.api.entity.Cliente;
import com.hotmart.suggest.api.exception.HotSuggestApiException;
import com.hotmart.suggest.api.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController extends BaseController{
	
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private ClienteService clienteService;

	@CrossOrigin
	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAnyRole('ADMIN')")
	public List<ClienteDTO> findAll(@Valid @RequestBody ClienteDTO clienteDTO) throws HotSuggestApiException{
		Cliente cliente = new Cliente();
		cliente.setCpf("123456789809");
		cliente.setNome("testando");
		List<Cliente> cliens = new ArrayList<Cliente>();
		cliens.add(cliente);
		cliens.add(cliente);
		cliens.add(cliente);
		final List<ClienteDTO> result = (List<ClienteDTO>) modelMapper.map(cliens, ArrayList.class);
		//throw new PocApiException(ApiExceptionMessage.INVALID_TOKEN);
		return result;
		
	}
	
	@CrossOrigin
	@GetMapping(value = "/findByName/{name}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ClienteDTO findByNome(@PathVariable("name") String name){
		Cliente cliente = clienteService.findByName(name);
		return (ClienteDTO) buildDTO(cliente, ClienteDTO.class);
	}
	
	@CrossOrigin
	@GetMapping(value = "/findByCpf")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ClienteDTO findByCpf(){
		Cliente cliente = clienteService.findByCpf();
		return (ClienteDTO) buildDTO(cliente, ClienteDTO.class);
	}
	
}
