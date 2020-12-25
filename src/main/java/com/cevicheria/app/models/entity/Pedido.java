package com.cevicheria.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Pedido")
public class Pedido implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String cliente;
	
	@ManyToOne
	@JoinColumn(name="lineaDePedido_id", referencedColumnName="id" )
	private LineaDePedido lineaDePedido;
	
	@ManyToOne
	@JoinColumn(name = "mesa_id", referencedColumnName = "id")
	private Mesa mesa;
	
	@Temporal(TemporalType.DATE)
	@Column
	//@DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
	private Date date;
	
	@PrePersist
	public void prePersist() {
		date = new Date();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LineaDePedido getLineaDePedido() {
		return lineaDePedido;
	}

	public void setLineaDePedido(LineaDePedido lineaDePedido) {
		this.lineaDePedido = lineaDePedido;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
