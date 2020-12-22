package com.cevicheria.app.models.entity;

import java.io.Serializable; 
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Pedido")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String cliente; 
	
	@Column
	private float precioTotal;

	@Column
	private boolean estado;//1 Pedido //0 Entregado

	@Column
	private boolean preferencia;//1 Aca //0 Llevar

	@Column
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

	/*
    @JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="pedido_id", referencedColumnName="id" )
	private Set<LineaDeBebida> lineaDeBebidas;

    @JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="pedido_id", referencedColumnName="id" )
    private Set<LineaDePlato> lineaDePlatos;

    @JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="pedido_id", referencedColumnName="id" )
    private Set<LineaDeGuarnicion> lineaDeGuarniciones;*/
	
	@PrePersist
	public void Prepersist() { 
		this.fecha = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isPreferencia() {
		return preferencia;
	}

	public void setPreferencia(boolean preferencia) {
		this.preferencia = preferencia;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	/*
	public Set<LineaDeBebida> getLineaDeBebidas() {
		return lineaDeBebidas;
	}
	
	

	public void setLineaDeBebidas(Set<LineaDeBebida> lineaDeBebidas) {
		this.lineaDeBebidas = lineaDeBebidas;
	    for(LineaDeBebida temp : this.lineaDeBebidas){
		       temp.setPedido(this);
		    }
	}

	public Set<LineaDePlato> getLineaDePlatos() {
		return lineaDePlatos;
	}

	public void setLineaDePlatos(Set<LineaDePlato> lineaDePlatos) {
		this.lineaDePlatos = lineaDePlatos; 
	    for(LineaDePlato temp : this.lineaDePlatos){
		       temp.setPedido(this);
		    }
	}

	public Set<LineaDeGuarnicion> getLineaDeGuarniciones() {
		return lineaDeGuarniciones;
	}

	public void setLineaDeGuarniciones(Set<LineaDeGuarnicion> lineaDeGuarniciones) {
		this.lineaDeGuarniciones = lineaDeGuarniciones;
	    for(LineaDeGuarnicion temp : this.lineaDeGuarniciones){
		       temp.setPedido(this);
		    }
	}
	*/
}
