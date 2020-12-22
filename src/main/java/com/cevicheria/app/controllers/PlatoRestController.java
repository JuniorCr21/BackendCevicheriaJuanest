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

import com.cevicheria.app.models.entity.Plato;
import com.cevicheria.app.services.IPlatoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cevicheria")
public class PlatoRestController {

	@Autowired
	private IPlatoService platoService;
	
	//METODOS GET
	
	@GetMapping("/platos")
	public List<Plato> index(){
		return platoService.findAll();
	}
	
	@GetMapping("/platos/{id}")
	public Plato show(@PathVariable Long id) {
		return platoService.findById(id);
	}
	
	@GetMapping("/platos/nombre/{nombre}")
	public List<Plato> buscarPlatoPorNombre(@PathVariable String nombre){
		return platoService.findByNombreIgnoreCaseContaining(nombre);
	}
	
	@GetMapping("/platos/tipo/{tipo}")
	public List<Plato> buscarPlatoPorTipo(@PathVariable String tipo){
		return platoService.findByTipo(tipo);
	}
	
	@GetMapping("/platos/count")
	public Long totalPlatos() {
		return platoService.count();
	}
	
	@GetMapping("/platos/estado/{estado}")
	public List<Plato> platosPorEstado(@PathVariable boolean estado){
		return platoService.customPlatoQuery(estado);
	}
	
	//METODOS POST
	
	@PostMapping("/platos")
	@ResponseStatus(HttpStatus.CREATED)
	public Plato create (@RequestBody Plato plato) {
		plato.setEstado(true);
		return platoService.save(plato);
	}
	
	//METODOS PUT
	
	@PutMapping("/platos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Plato update (@RequestBody Plato plato,@PathVariable Long id) {
		Plato platoActual = platoService.findById(id);
		platoActual.setEstado(true);
		platoActual.setNombre(plato.getNombre());
		platoActual.setPrecio(plato.getPrecio());
		platoActual.setTipo(plato.getTipo());
		
		return platoService.save(platoActual);
	}
	
	@PutMapping("/platos/estatus/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Plato updateEstado (@PathVariable Long id) {
		Plato platoActual = platoService.findById(id);
		platoActual.setEstado(!(platoActual.isEstado()));
	
		return platoService.save(platoActual);
	}

	//METODOS DELETE
	
	@DeleteMapping("/platos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id) {
		platoService.deleteById(id);
	}
}
