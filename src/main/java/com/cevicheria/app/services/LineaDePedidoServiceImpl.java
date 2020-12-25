package com.cevicheria.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cevicheria.app.models.dao.ILineaDePedidoDao;
import com.cevicheria.app.models.entity.LineaDePedido;

@Service
public class LineaDePedidoServiceImpl implements ILineaDePedidoService {
	
	@Autowired
	private ILineaDePedidoDao lineaDePedidoDao;

	@Transactional(readOnly = true)
	@Override
	public List<LineaDePedido> findAll() {
		return lineaDePedidoDao.findAll();
	}

	@Transactional()
	@Override
	public LineaDePedido save(LineaDePedido lineaDePedido) {
		return lineaDePedidoDao.save(lineaDePedido);
	}

	@Transactional(readOnly = true)
	@Override
	public LineaDePedido findById(Long id) {
		return lineaDePedidoDao.findById(id).orElse(null);
	}

	@Transactional()
	@Override
	public void deleteById(Long id) {
		lineaDePedidoDao.deleteById(id);
	}

}
