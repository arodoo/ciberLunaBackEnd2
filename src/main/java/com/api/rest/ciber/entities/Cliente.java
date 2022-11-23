package com.api.rest.ciber.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //auto-generated id
	private Long id_cliente;

	private String nombre;

	private String apellido;

	private String telefono;
	
	@ManyToOne
	@JoinColumn(name = "empleado_id")					 //Many-to-one relationship in database
	private Empleado empleado;

	public Cliente() {

	}

	public Cliente(String nombre, String apellido, String telefono, Empleado empleado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.empleado = empleado;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
