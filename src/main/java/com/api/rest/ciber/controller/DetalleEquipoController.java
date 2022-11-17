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

import com.api.rest.ciber.dao.DetalleEquipoDAO;
import com.api.rest.ciber.entities.DetalleEquipo;
import com.api.rest.ciber.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api") // http://localhost:8080/api/detalles_equipos
public class DetalleEquipoController {

	@Autowired
	private DetalleEquipoDAO detalleEquipoDAO;

	@GetMapping("/detalles_equipos")
	public List<DetalleEquipo> getAllDetallesEquipo() {
		return detalleEquipoDAO.findAll();
	}

	@GetMapping("detalles_equipos/{id_detalle_equipo}")
	public ResponseEntity<DetalleEquipo> getDetalleEquipoById(
			@PathVariable(value = "id_detalle_equipo") Long detalleEquipoId) throws ResourceNotFoundException {
		DetalleEquipo detalleEquipo = detalleEquipoDAO.findById(detalleEquipoId).orElseThrow(
				() -> new ResourceNotFoundException("No se encontró un detalle para el id " + detalleEquipoId));
		return ResponseEntity.ok().body(detalleEquipo);
	}

	@PostMapping("/detalles_equipos")
	public DetalleEquipo createDetalleEquipo(@RequestBody DetalleEquipo detalleEquipo) {
		return detalleEquipoDAO.save(detalleEquipo);
	}

	@DeleteMapping("/detalles_equipos/{id_detalle_equipo}")
	public Map<String, Boolean> deleteDetalleEquipo(@PathVariable(value = "id_detalle_equipo") Long detalleEquipoId)
			throws ResourceNotFoundException {
		DetalleEquipo detalleEquipo = detalleEquipoDAO.findById(detalleEquipoId).orElseThrow(
				() -> new ResourceNotFoundException("No se encontró un detalle para el id: " + detalleEquipoId));
		detalleEquipoDAO.delete(detalleEquipo);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
