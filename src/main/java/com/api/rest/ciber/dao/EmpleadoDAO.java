package com.api.rest.ciber.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.ciber.entities.Empleado;

public interface EmpleadoDAO extends JpaRepository<Empleado, Long>{

}
