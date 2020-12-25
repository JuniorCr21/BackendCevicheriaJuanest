package com.cevicheria.app.services;

import java.util.List;

import com.cevicheria.app.models.entity.LineaDePedido;

public interface ILineaDePedidoService {
	List<LineaDePedido> findAll();
	public LineaDePedido save (LineaDePedido lineaDePedido);
	public LineaDePedido findById(Long id);
	public void deleteById(Long id);
}
