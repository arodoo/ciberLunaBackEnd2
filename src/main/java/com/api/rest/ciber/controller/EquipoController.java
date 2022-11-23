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

import com.api.rest.ciber.dao.EquipoDAO;
import com.api.rest.ciber.entities.Equipo;
import com.api.rest.ciber.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api") // http://localhost:8080/api/equipos
public class EquipoController {

	@Autowired
	private EquipoDAO equipoDAO; //Auto injectable DAO class

	@GetMapping("/equipos")
	public List<Equipo> getAllEquipos() {
		return equipoDAO.findAll();
	}

	@GetMapping("/equipos/{id_equipo}")
	public ResponseEntity<Equipo> getEquipoById(@PathVariable(value = "id_equipo") Long equipoId)
			throws ResourceNotFoundException {
		Equipo equipo = equipoDAO.findById(equipoId)
				.orElseThrow(() -> new ResourceNotFoundException("No se encontró un equipo para el id: " + equipoId));
		return ResponseEntity.ok().body(equipo);
	}
	
	@PostMapping("/equipos")
	public Equipo createEquipo(@RequestBody Equipo equipo) {
		return equipoDAO.save(equipo);
	}
	
	@DeleteMapping("/equipos/{id_equipo}")
	public Map<String, Boolean> deleteEquipo(@PathVariable(value = "id_equipo") Long equipoId) throws ResourceNotFoundException {
		Equipo equipo = equipoDAO.findById(equipoId).orElseThrow(() -> new ResourceNotFoundException("No se encontró un equipo para el id: " + equipoId));
		equipoDAO.delete(equipo);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@PutMapping("equipos/{id_equipo}")
	public ResponseEntity<Equipo> updateEquipo(@PathVariable(value = "id_equipo") Long equipoId, @RequestBody Equipo equipoDetails) throws ResourceNotFoundException {
		Equipo equipo = equipoDAO.findById(equipoId).orElseThrow(() -> new ResourceNotFoundException("No se encontró un equipo para el id:" + equipoId));
		equipo.setMarca(equipoDetails.getMarca());
		equipo.setModelo(equipoDetails.getModelo());
		equipo.setFecha_recibido(equipoDetails.getFecha_recibido());
		equipo.setEntregado(equipoDetails.getEntregado());
		equipo.setEstado_reparacion(equipoDetails.getEstado_reparacion());
		
		final Equipo updateEquipo = equipoDAO.save(equipo);
		return ResponseEntity.ok(updateEquipo);
	}
}
