package com.api.rest.ciber.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.ciber.entities.Factura;

public interface FacturaDAO extends JpaRepository<Factura, Long>{

}
