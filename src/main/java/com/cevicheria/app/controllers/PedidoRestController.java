package com.cevicheria.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cevicheria.app.models.entity.Pedido;
import com.cevicheria.app.services.IPedidoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cevicheria")
public class PedidoRestController {
	
	@Autowired
	private IPedidoService pedidoService;
	
	//METODOS GET
	@GetMapping("/pedidos")
	public List<Pedido> index(){
		return pedidoService.findAll();
	}
	
	@GetMapping("/pedidos/{id}")
	public Pedido show(@PathVariable Long id) {
		return pedidoService.findById(id);
	}
	
	//METODOS POST
	@PostMapping("/pedido")
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido save(@RequestBody Pedido pedido) {
		return pedidoService.save(pedido);
	}
}
