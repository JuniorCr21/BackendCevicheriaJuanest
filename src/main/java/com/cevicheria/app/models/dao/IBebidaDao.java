package com.cevicheria.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cevicheria.app.models.entity.Bebida;
@Repository
public interface IBebidaDao extends JpaRepository<Bebida,Long>{
	@Query(value="SELECT b FROM Bebida b WHERE b.estado=:estado")
	public List<Bebida> customBebidaQuery(@Param("estado") boolean estado);
	
	public List<Bebida> findByNombreIgnoreCaseContaining(String cadena);
}
