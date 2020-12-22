package com.cevicheria.app.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cevicheria.app.models.entity.Pedido;

public interface IPedidoService {
 
	public Pedido findByIdPedido(Long id);
	public Pedido savePedido(Pedido pedido); 
 	public void deletePedido(Long idPedido);  
	public Page<Pedido> getAll(Pageable pageable);
	public Page<Pedido> getData(HashMap<String, Object> conditions, Pageable pageable);
	public int countPedido(); 
}
