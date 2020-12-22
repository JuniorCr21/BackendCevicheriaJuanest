package com.cevicheria.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cevicheria.app.models.dao.IBebidaDao;
import com.cevicheria.app.models.entity.Bebida;

@Service
public class BebidaServiceImpl implements IBebidaService {

	@Autowired
	private IBebidaDao bebidaDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Bebida> findAll() {
		return bebidaDao.findAll();
	}

	@Transactional
	@Override
	public Bebida save(Bebida bebida) {
		return bebidaDao.save(bebida);
	}

	@Transactional(readOnly = true)
	@Override
	public Bebida findById(Long id) {
		return bebidaDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		bebidaDao.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Long count() {
		return bebidaDao.count();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Bebida> customBebidaQuery(boolean estado) {
		return bebidaDao.customBebidaQuery(estado);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Bebida> findByNombreIgnoreCaseContaining(String cadena) {
		return bebidaDao.findByNombreIgnoreCaseContaining(cadena);
	}

}
