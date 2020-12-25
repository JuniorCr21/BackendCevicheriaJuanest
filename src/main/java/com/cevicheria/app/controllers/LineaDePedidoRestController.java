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

import com.cevicheria.app.models.entity.LineaDePedido;
import com.cevicheria.app.services.ILineaDePedidoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cevicheria")
public class LineaDePedidoRestController {

	@Autowired
	private ILineaDePedidoService lineaDePedido;
	
	//METODOS GET
	@GetMapping("/lineaDePedidos")
	public List<LineaDePedido> index(){
		return lineaDePedido.findAll();
	}
	
	@GetMapping("/lineaDePedido/{id}")
	public LineaDePedido show(@PathVariable Long id) {
		return lineaDePedido.findById(id);
	}
	
	//METODOS POST
	@PostMapping("/lineaDePedido")
	@ResponseStatus(HttpStatus.CREATED)
	public LineaDePedido save (@RequestBody LineaDePedido lineaDePedido) {
		return this.lineaDePedido.save(lineaDePedido);
	}
}
