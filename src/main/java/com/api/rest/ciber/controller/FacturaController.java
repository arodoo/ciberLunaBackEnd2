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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.ciber.dao.FacturaDAO;
import com.api.rest.ciber.entities.Factura;
import com.api.rest.ciber.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class FacturaController {

	@Autowired
	private FacturaDAO facturaDAO;

	@GetMapping("/facturas")
	public List<Factura> getAllFacturas() {
		return facturaDAO.findAll();
	}

	@GetMapping("/facturas/{no_factura}")
	public ResponseEntity<Factura> getFacturaById(@PathVariable(value = "no_factura") Long facturaId)
			throws ResourceNotFoundException {
		Factura factura = facturaDAO.findById(facturaId)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontró un cliente con el id: " + facturaId));
		return ResponseEntity.ok().body(factura);
	}

	@PostMapping("/facturas/{no_factura}")
	public Factura createFactura(@RequestBody Factura factura) {
		return facturaDAO.save(factura);
	}

	@DeleteMapping("/facturas/{no_factura}")
	public Map<String, Boolean> Factura(@PathVariable(value = "no_factura") Long facturaId)
			throws ResourceNotFoundException {
		Factura factura = facturaDAO.findById(facturaId)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontró un cliente con el id: " + facturaId));
		facturaDAO.delete(factura);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
