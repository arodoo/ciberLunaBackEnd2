package com.api.rest.ciber.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DETALLE_EQUIPOS")
public class DetalleEquipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_detalle_equipo;
	
	private String detalle_problema;
	
	private Long costo_reparacion;
	
	@ManyToOne
	@JoinColumn(name = "equipo_id")
	private Equipo equipo;
	
	public DetalleEquipo() {
		
	}

	public DetalleEquipo(String detalle_problema, Long costo_reparacion, Equipo equipo) {
		super();
		this.detalle_problema = detalle_problema;
		this.costo_reparacion = costo_reparacion;
		this.equipo = equipo;
	}

	public Long getId_detalle_equipo() {
		return id_detalle_equipo;
	}

	public void setId_detalle_equipo(Long id_detalle_equipo) {
		this.id_detalle_equipo = id_detalle_equipo;
	}

	public String getDetalle_problema() {
		return detalle_problema;
	}

	public void setDetalle_problema(String detalle_problema) {
		this.detalle_problema = detalle_problema;
	}

	public Long getCosto_reparacion() {
		return costo_reparacion;
	}

	public void setCosto_reparacion(Long costo_reparacion) {
		this.costo_reparacion = costo_reparacion;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
}
