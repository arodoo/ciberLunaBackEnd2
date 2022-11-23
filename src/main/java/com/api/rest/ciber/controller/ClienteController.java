package com.api.rest.ciber.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.ciber.dao.ClienteDAO;
import com.api.rest.ciber.entities.Cliente;
import com.api.rest.ciber.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api") // http://localhost:8080/api/clientes
public class ClienteController {

	@Autowired
	private ClienteDAO clienteDAO; // Auto injectable DAO class

	@GetMapping("/clientes") // Getting all the clients
	public List<Cliente> getAllClientes() {
		return clienteDAO.findAll();
	}

	@GetMapping("/clientes/{id_cliente}") // Getting a client by Id
	public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id_cliente") Long clienteId)
			throws ResourceNotFoundException {
		Cliente cliente = clienteDAO.findById(clienteId)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontró un cliente para el id :" + clienteId));
		return ResponseEntity.ok().body(cliente);
	}

	@PostMapping("clientes") // Adding a new client
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteDAO.save(cliente);
	}

	@DeleteMapping("/clientes/{id_cliente}") // Deleting a client
	public Map<String, Boolean> Cliente(@PathVariable(value = "id_cliente") Long clienteId)
			throws ResourceNotFoundException {
		Cliente cliente = clienteDAO.findById(clienteId)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontró un cliente con el id: " + clienteId));
		clienteDAO.delete(cliente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PutMapping("/clientes/{id_cliente}") // Editing a client
	public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id_cliente") Long clienteId,
			@RequestBody Cliente clienteDetails) throws ResourceNotFoundException {
		Cliente cliente = clienteDAO.findById(clienteId)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontró un cliente para el id: " + clienteId));
		cliente.setNombre(clienteDetails.getNombre());
		cliente.setApellido(clienteDetails.getApellido());
		cliente.setTelefono(clienteDetails.getTelefono());
		// cliente.setEmpleado(clienteDetails.getEmpleado());

		final Cliente updateCliente = clienteDAO.save(cliente);
		return ResponseEntity.ok(updateCliente);
	}
}
