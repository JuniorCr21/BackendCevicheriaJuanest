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

import com.cevicheria.app.models.entity.Guarnicion;
import com.cevicheria.app.services.IGuarnicionService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cevicheria")
public class GuarnicionRestController {

	@Autowired
	private IGuarnicionService guarnicionService;
	
	//METODOS GET
	
	@GetMapping("/guarniciones")
	public List<Guarnicion> index(){
		return guarnicionService.findAll();
	}
	
	@GetMapping("/guarniciones/{id}")
	public Guarnicion show (@PathVariable Long id) {
		return guarnicionService.findById(id);
	}
	
	@GetMapping("/guarniciones/nombre/{nombre}")
	public List<Guarnicion> buscarGuarnicionPorNombre(@PathVariable String nombre){
		return guarnicionService.findByNombreIgnoreCaseContaining(nombre);
	}
	
	@GetMapping("/guarniciones/count")
	public Long totalGuarniciones() {
		return guarnicionService.count();
	}
	
	@GetMapping("/guarniciones/estado/{estado}")
	public List<Guarnicion> guarnicionPorEstado(@PathVariable boolean estado){
		return guarnicionService.customGuarnicionQuery(estado);
	}
	
	//METODOS POST
	
	@PostMapping("/guarniciones")
	@ResponseStatus(HttpStatus.CREATED)
	public Guarnicion create (@RequestBody Guarnicion guarnicion) {
		guarnicion.setEstado(true);
		return guarnicionService.save(guarnicion);
	}
	
	//METODOS PUT
	
	@PutMapping("/guarniciones/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Guarnicion update (@RequestBody Guarnicion guarnicion,@PathVariable Long id) {
		Guarnicion guarnicionActual = guarnicionService.findById(id);
		guarnicionActual.setEstado(true);
		guarnicionActual.setNombre(guarnicion.getNombre());
		guarnicionActual.setPrecio(guarnicion.getPrecio());
		
		return guarnicionService.save(guarnicionActual);
	}
	
	@PutMapping("/guarniciones/estatus/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Guarnicion cambiarEstado(@PathVariable Long id) {
		Guarnicion guarnicionActual = guarnicionService.findById(id);
		guarnicionActual.setEstado(!(guarnicionActual.isEstado()));
		
		return guarnicionService.save(guarnicionActual);
	}

	//METODOS DELETE
	
	@DeleteMapping("/guarniciones/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete (@PathVariable Long id) {
		guarnicionService.deleteById(id);
	}
}
