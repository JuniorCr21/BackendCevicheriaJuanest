package com.cevicheria.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cevicheria.app.models.entity.LineaDePedido;

@Repository
public interface ILineaDePedidoDao extends JpaRepository<LineaDePedido, Long>{

}
