package com.cevicheria.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cevicheria.app.models.entity.Bebida;
import com.cevicheria.app.services.IBebidaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cevicheria")
public class BebidaRestController {

	@Autowired
	private IBebidaService bebidaService;
	
	//METODOS GET
	
	@GetMapping("/bebidas")
	public List<Bebida> index(){
		return bebidaService.findAll();
	}
	
	@GetMapping("/bebidas/{id}")
	public Bebida show(@PathVariable Long id) {
		return bebidaService.findById(id);
	}
	
	@GetMapping("/bebidas/nombre/{nombre}")
	public List<Bebida> buscarBebidaPorNombre(@PathVariable String nombre){
		return bebidaService.findByNombreIgnoreCaseContaining(nombre);
	}
	
	@GetMapping("/bebidas/count")
	public Long totalBebidas(){
		return bebidaService.count();
	}
	
	@GetMapping("/bebidas/estado/{estado}")
	public List<Bebida> bebidaPorEstado(@PathVariable boolean estado){
		return bebidaService.customBebidaQuery(estado);
	}
	
	//METODOS POST
	
	@PostMapping("/bebidas")
	@ResponseStatus(HttpStatus.CREATED)
	public Bebida create (@RequestBody Bebida bebida) {
		bebida.setEstado(true);
		return bebidaService.save(bebida);
	}
	
	//METODOS PUT
	
	@PutMapping("/bebidas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Bebida update (@RequestBody Bebida bebida,@PathVariable Long id) {
		Bebida bebidaActual = bebidaService.findById(id);
		bebidaActual.setEstado(true);
		bebidaActual.setLitraje(bebida.getLitraje());
		bebidaActual.setNombre(bebida.getNombre());
		bebidaActual.setPrecio(bebida.getPrecio());
		
		return bebidaService.save(bebidaActual);
	}
	
	@PutMapping("/bebidas/estatus/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Bebida updateEstado(@PathVariable Long id) {
		Bebida bebidaActual = bebidaService.findById(id);
		bebidaActual.setEstado(!(bebidaActual.isEstado()));
		
		return bebidaService.save(bebidaActual);
	}
	
	//METODOS DELETE
	
	@DeleteMapping("/bebidas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id) {
		bebidaService.deleteById(id);
	}
}
