package com.cevicheria.app.services;

import java.util.List;

import com.cevicheria.app.models.entity.Mesa;

public interface IMesaService {
	public List<Mesa> findAll();
	public Mesa save (Mesa mesa);
	public Mesa findById(Long id);
	public void deleteById (Long id);
	public List<Mesa> customMesaQuery(boolean estado);
	public List<Mesa> customMesaQueryDisponibilidad(boolean estado);
	public List<Mesa> findByCodigoIgnoreCaseContaining(String cadena);
	public Long count();
}
