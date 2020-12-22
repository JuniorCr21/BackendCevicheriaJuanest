package com.cevicheria.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cevicheria.app.models.entity.Plato;

@Repository
public interface IPlatoDao extends JpaRepository<Plato,Long>{
	@Query(value="SELECT p FROM Plato p WHERE p.estado=:estado")
	public List<Plato> customPlatoQuery(@Param("estado") boolean estado);
	public List<Plato> findByTipo(String tipo);
	public List<Plato> findByNombreIgnoreCaseContaining(String cadena);
}
