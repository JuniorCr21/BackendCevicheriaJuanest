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

import com.cevicheria.app.models.entity.Mesa;
import com.cevicheria.app.services.IMesaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cevicheria")
public class MesaRestController {

	@Autowired
	private IMesaService mesaService;
	
	//METODOS GET
	
	@GetMapping("/mesas")
	public List<Mesa> index(){
		return mesaService.findAll();
	}
	
	@GetMapping("/mesas/codigo/{codigo}")
	public List<Mesa> buscarMesaPorCodigo(@PathVariable String codigo){
		return mesaService.findByCodigoIgnoreCaseContaining(codigo);
	}
	
	@GetMapping("/mesas/{id}")
	public Mesa show(@PathVariable Long id) {
		return mesaService.findById(id);
	}
	
	@GetMapping("/mesas/count")
	public Long totalMesas() {
		return mesaService.count();
	}
	
	@GetMapping("/mesas/estado/{estado}")
	public List<Mesa> mesasPorEstado(@PathVariable boolean estado){
		return mesaService.customMesaQuery(estado);
	}
	
	@GetMapping("/mesas/disponibilidad/{estado}")
	public List<Mesa> mesasPorDisponibilidad(@PathVariable boolean estado){
		return mesaService.customMesaQueryDisponibilidad(estado);
	}
	
	//METODOS POST
	
	@PostMapping("/mesas")
	@ResponseStatus(HttpStatus.CREATED)
	public Mesa create (@RequestBody Mesa mesa) {
		mesa.setEstado(true);
		mesa.setDisponibilidad(true);
		return mesaService.save(mesa);
	}
	
	//METODOS UPDATE
	
	@PutMapping("/mesas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Mesa update (@RequestBody Mesa mesa, @PathVariable Long id) {
		Mesa mesaActual = mesaService.findById(id);
		mesaActual.setCodigo(mesa.getCodigo());
		mesaActual.setCapacidad(mesa.getCapacidad());
		mesaActual.setDisponibilidad(true);
		mesaActual.setEstado(mesa.isEstado());
		
		return mesaService.save(mesaActual);
	}
	
	@PutMapping("/mesas/estatus/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Mesa actualizarEstadoMesa(@PathVariable Long id){
		Mesa mesaActual = mesaService.findById(id);
		mesaActual.setDisponibilidad(true);
		mesaActual.setEstado(!(mesaActual.isEstado()));
		
		return mesaService.save(mesaActual);
	}
	
	//METODOS DELETE
	
	@DeleteMapping("/mesas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id) {
		mesaService.deleteById(id);
	}
	
}
