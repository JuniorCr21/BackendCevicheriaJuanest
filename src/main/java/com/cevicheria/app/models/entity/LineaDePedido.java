package com.cevicheria.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LineaDePedido")
public class LineaDePedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="plato_id", referencedColumnName="id",nullable = true)
	private Plato plato;
	
	@ManyToOne
	@JoinColumn(name="bebida_id", referencedColumnName="id",nullable = true)
	private Bebida bebida;
	
	@ManyToOne
	@JoinColumn(name="guarnicion_id", referencedColumnName="id",nullable = true)
	private Guarnicion guarnicion;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public Bebida getBebida() {
		return bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}

	public Guarnicion getGuarnicion() {
		return guarnicion;
	}

	public void setGuarnicion(Guarnicion guarnicion) {
		this.guarnicion = guarnicion;
	}

}
