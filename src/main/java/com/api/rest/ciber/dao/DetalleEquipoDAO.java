package com.api.rest.ciber.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.ciber.entities.DetalleEquipo;

public interface DetalleEquipoDAO extends JpaRepository<DetalleEquipo, Long>{
	//DAO interface, here we get methods as "findAll, findById, delete, add, put, etc"
}
