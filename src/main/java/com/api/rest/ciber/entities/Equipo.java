package com.api.rest.ciber.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EQUIPOS")
public class Equipo {

	@Id
	private int id_equipo;

	private String marca;

	private String modelo;

	private String fecha_recibido;

	private String fecha_entregado;

	private String estado_reparacion;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "id_empleado")
	private Empleado empleado;
	
	public Equipo() {
		
	}

	public Equipo( String marca, String modelo, String fecha_recibido, String fecha_entregado,
			String estado_reparacion, Cliente cliente, Empleado empleado) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.fecha_recibido = fecha_recibido;
		this.fecha_entregado = fecha_entregado;
		this.estado_reparacion = estado_reparacion;
		this.cliente = cliente;
		this.empleado = empleado;
	}

	public int getId_equipo() {
		return id_equipo;
	}

	public void setId_equipo(int id_equipo) {
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

	public String getFecha_recibido() {
		return fecha_recibido;
	}

	public void setFecha_recibido(String fecha_recibido) {
		this.fecha_recibido = fecha_recibido;
	}

	public String getFecha_entregado() {
		return fecha_entregado;
	}

	public void setFecha_entregado(String fecha_entregado) {
		this.fecha_entregado = fecha_entregado;
	}

	public String getEstado_reparacion() {
		return estado_reparacion;
	}

	public void setEstado_reparacion(String estado_reparacion) {
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
