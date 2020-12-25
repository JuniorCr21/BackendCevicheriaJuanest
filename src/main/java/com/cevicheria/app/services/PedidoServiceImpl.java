package com.cevicheria.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cevicheria.app.models.dao.IPedidoDao;
import com.cevicheria.app.models.entity.Pedido;

@Service
public class PedidoServiceImpl implements IPedidoService {

	@Autowired
	private IPedidoDao pedidoDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Pedido> findAll() {
		return pedidoDao.findAll();
	}

	@Transactional
	@Override
	public Pedido save(Pedido pedido) {
		return pedidoDao.save(pedido);
	}

	@Transactional(readOnly = true)
	@Override
	public Pedido findById(Long id) {
		return pedidoDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		pedidoDao.deleteById(id);
	}

}
