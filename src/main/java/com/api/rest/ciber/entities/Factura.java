package com.api.rest.ciber.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FACTURAS")
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no_factura;
	
	private String metodo_pago;
	
	private Long costo_total;
	
	@OneToOne
	@JoinColumn(name = "equipo_id")
	private Equipo equipo;
	
	public Factura() {
		
	}

	public Factura(String metodo_pago, Long costo_total, Equipo equipo) {
		super();
		this.metodo_pago = metodo_pago;
		this.costo_total = costo_total;
		this.equipo = equipo;
	}

	public Long getNo_factura() {
		return no_factura;
	}

	public void setNo_factura(Long no_factura) {
		this.no_factura = no_factura;
	}

	public String getMetodo_pago() {
		return metodo_pago;
	}

	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}

	public Long getCosto_total() {
		return costo_total;
	}

	public void setCosto_total(Long costo_total) {
		this.costo_total = costo_total;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
}
