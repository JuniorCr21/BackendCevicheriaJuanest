package com.cevicheria.app.services;

import java.util.List;

import com.cevicheria.app.models.entity.Bebida;

public interface IBebidaService {
	public List<Bebida> findAll();
	public Bebida save (Bebida bebida);
	public Bebida findById(Long id);
	public void deleteById (Long id);
	public List<Bebida> customBebidaQuery(boolean estado);
	public List<Bebida> findByNombreIgnoreCaseContaining(String cadena);
	public Long count();
}
