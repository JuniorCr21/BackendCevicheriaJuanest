package com.cevicheria.app.services;

import java.util.List;

import com.cevicheria.app.models.entity.Pedido;

public interface IPedidoService{
	public List<Pedido> findAll();
	public Pedido save(Pedido pedido);
	public Pedido findById(Long id);
	public void deleteById(Long id);
}
