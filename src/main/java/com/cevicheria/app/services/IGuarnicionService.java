package com.cevicheria.app.services;

import java.util.List;

import com.cevicheria.app.models.entity.Guarnicion;

public interface IGuarnicionService {
	public List<Guarnicion> findAll();
	public Guarnicion save (Guarnicion guarnicion);
	public Guarnicion findById(Long id);
	public void deleteById (Long id);
	public List<Guarnicion> customGuarnicionQuery(boolean estado);
	public List<Guarnicion> findByNombreIgnoreCaseContaining(String cadena);
	public Long count();
}
