package com.cevicheria.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cevicheria.app.models.dao.IMesaDao;
import com.cevicheria.app.models.entity.Mesa;

@Service
public class MesaServiceImpl implements IMesaService{

	@Autowired
	private IMesaDao mesaDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Mesa> findAll() {
		return mesaDao.findAll();
	}

	@Transactional
	@Override
	public Mesa save(Mesa mesa) {
		return mesaDao.save(mesa);
	}

	@Transactional(readOnly = true)
	@Override
	public Mesa findById(Long id) {
		return mesaDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		mesaDao.deleteById(id);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Mesa> customMesaQuery(boolean estado) {
		return mesaDao.customMesaQuery(estado);
	}

	@Transactional(readOnly = true)
	@Override
	public Long count() {
		return mesaDao.count();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Mesa> customMesaQueryDisponibilidad(boolean estado) {
		return mesaDao.customMesaQueryDisponibilidad(estado);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Mesa> findByCodigoIgnoreCaseContaining(String cadena){
		return mesaDao.findByCodigoIgnoreCaseContaining(cadena);
	}

	
}
