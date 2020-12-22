package com.cevicheria.app.services;

import java.util.List;

import com.cevicheria.app.models.entity.Plato;

public interface IPlatoService {
	public List<Plato> findAll();
	public Plato save(Plato plato);
	public Plato findById(Long id);
	public void deleteById (Long id);
	public List<Plato> customPlatoQuery(boolean estado);
	public List<Plato> findByTipo(String tipo);
	public List<Plato> findByNombreIgnoreCaseContaining(String cadena);
	public Long count();
}
