package com.cevicheria.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cevicheria.app.models.entity.Mesa;

@Repository
public interface IMesaDao extends JpaRepository<Mesa, Long>{
	@Query(value="SELECT t FROM Mesa t WHERE t.estado=:estado")
	public List<Mesa> customMesaQuery(@Param("estado") boolean estado);
	
	@Query(value="SELECT t FROM Mesa t WHERE t.disponibilidad=:disponibilidad")
	public List<Mesa> customMesaQueryDisponibilidad(@Param("disponibilidad") boolean estado);
	
	public List<Mesa> findByCodigoIgnoreCaseContaining(String cadena);
}
