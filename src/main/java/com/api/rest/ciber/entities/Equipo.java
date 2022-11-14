package com.api.rest.ciber.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EQUIPOS")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_equipo;

	private String marca;

	private String modelo;

	java.sql.Date fecha_recibido = new java.sql.Date(getDate());

	private Boolean entregado = false;

	private Boolean estado_reparacion = false;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "empleado_id")
	private Empleado empleado;

	private Long getDate() {
		long millis = System.currentTimeMillis();
		return millis;
	}

	public Equipo() {

	}

	public Equipo(String marca, String modelo, Date fecha_recibido, Boolean entregado, Boolean estado_reparacion,
			Cliente cliente, Empleado empleado) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.fecha_recibido = fecha_recibido;
		this.entregado = entregado;
		this.estado_reparacion = estado_reparacion;
		this.cliente = cliente;
		this.empleado = empleado;
	}

	public Long getId_equipo() {
		return id_equipo;
	}

	public void setId_equipo(Long id_equipo) {
		this.id_equipo = id_equipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public java.sql.Date getFecha_recibido() {
		return fecha_recibido;
	}

	public void setFecha_recibido(java.sql.Date fecha_recibido) {
		this.fecha_recibido = fecha_recibido;
	}

	public Boolean getEntregado() {
		return entregado;
	}

	public void setEntregado(Boolean entregado) {
		this.entregado = entregado;
	}

	public Boolean getEstado_reparacion() {
		return estado_reparacion;
	}

	public void setEstado_reparacion(Boolean estado_reparacion) {
		this.estado_reparacion = estado_reparacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
