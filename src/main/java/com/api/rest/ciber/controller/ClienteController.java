package com.api.rest.ciber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.ciber.dao.ClienteDAO;
import com.api.rest.ciber.entities.Cliente;
import com.api.rest.ciber.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api") // http://localhost:8080/api/clientes
public class ClienteController {

	@Autowired
	private ClienteDAO clienteDAO;

	@GetMapping("/clientes")
	public List<Cliente> getAllClientes() {
		return clienteDAO.findAll();
	}

	@GetMapping("/clientes/{id}_cliente")
	public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id_cliente") Long clienteId)
			throws ResourceNotFoundException {
		Cliente cliente = clienteDAO.findById(clienteId)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontró un cliente para el id :" + clienteId));
		return ResponseEntity.ok().body(cliente);
	}
}
