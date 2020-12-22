package com.cevicheria.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cevicheria.app.models.entity.Guarnicion;
@Repository
public interface IGuarnicionDao extends JpaRepository<Guarnicion,Long>{
	@Query(value="SELECT g FROM Guarnicion g WHERE g.estado=:estado")
	public List<Guarnicion> customGuarnicionQuery(@Param("estado") boolean estado);
	
	public List<Guarnicion> findByNombreIgnoreCaseContaining(String cadena);
}
