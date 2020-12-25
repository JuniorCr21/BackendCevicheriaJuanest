package com.cevicheria.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Plato")
public class Plato implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	private String nombre;
	
	@Column
	private double precio;
	
	@Column
	private String tipo;
	
	@Column
	private boolean estado;
	
	/*
	@OneToMany(targetEntity = LineaDePedido.class)
	private List<LineaDePedido> lineaDePedidos;*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/*
	public List<LineaDePedido> getLineaDePedidos() {
		return lineaDePedidos;
	}

	public void setLineaDePedidos(List<LineaDePedido> lineaDePedidos) {
		this.lineaDePedidos = lineaDePedidos;
	}*/
	
	
}
