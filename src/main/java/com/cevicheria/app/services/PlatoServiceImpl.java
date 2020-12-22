package com.cevicheria.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cevicheria.app.models.dao.IPlatoDao;
import com.cevicheria.app.models.entity.Plato;

@Service
public class PlatoServiceImpl implements IPlatoService {

	@Autowired
	private IPlatoDao platoDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Plato> findAll() {
		return platoDao.findAll();
	}

	@Transactional
	@Override
	public Plato save(Plato plato) {
		return platoDao.save(plato);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Plato findById(Long id) {
		return platoDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		platoDao.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Long count() {
		return platoDao.count();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Plato> customPlatoQuery(boolean estado) {
		return platoDao.customPlatoQuery(estado);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Plato> findByNombreIgnoreCaseContaining(String cadena) {
		return platoDao.findByNombreIgnoreCaseContaining(cadena);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Plato> findByTipo(String tipo) {
		return platoDao.findByTipo(tipo);
	}

}
