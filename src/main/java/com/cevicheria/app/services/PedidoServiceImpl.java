package com.cevicheria.app.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cevicheria.app.models.dao.IPedidoDao;
import com.cevicheria.app.models.entity.Pedido; 
import com.cevicheria.app.models.entity.Mesa; 

@Service
public class PedidoServiceImpl implements IPedidoService {

	@Autowired
	private IPedidoDao pedidoDao;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly=true) 
	@Override
	public Pedido findByIdPedido(Long id) {
		return pedidoDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Pedido savePedido(Pedido pedido) {
		return pedidoDao.save(pedido);
	}

	@Transactional
	@Override
	public void deletePedido(Long idPedido) {
		pedidoDao.deleteById(idPedido);
	}

	@Transactional
	@Override
	public Page<Pedido> getAll(Pageable pageable) {
		return pedidoDao.findAll(pageable);
	}
	//BUSQUEDA AVANZADA
	public static final String GREATER_THAN="greater";
	public static final String LESS_THAN="less";
	public static final String EQUAL="equal";
	//BUSCAR PEDIDOS ADVANCED
	@Transactional(readOnly=true)
	@Override
	public Page<Pedido> getData(HashMap<String, Object> conditions, Pageable pageable) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pedido> query= cb.createQuery(Pedido.class);
		Root<Pedido> root = query.from(Pedido.class);
			
		List<Predicate> predicates = new ArrayList<Predicate>();
		conditions.forEach((field,value) ->
		{
			switch (field)
			{
				case "mesa": 
					CriteriaQuery<Mesa> criteriaMesa= cb.createQuery(Mesa.class); 
					Root<Mesa> rootMesa = criteriaMesa.from(Mesa.class); 
					Predicate predicateMesa = cb.equal(rootMesa.get("codigo"), "%"+(String)value+"%");
					criteriaMesa.select(rootMesa).where(predicateMesa);
					Long mesa =	entityManager.createQuery(criteriaMesa).getSingleResult().getId(); 
					Expression<Mesa> expVehiculos = root.get("mesa");
					predicates.add(expVehiculos.in(mesa)); 
					break;
				case "cliente":  
					predicates.add(cb.like(root.get("cliente"), "%"+(String)value+"%"));
					break;
				case "precioTotal":
					String precioTotalCondition=(String) conditions.get("precioTotalCondicion");					
					switch (precioTotalCondition)
					{
						case GREATER_THAN:
							predicates.add(cb.greaterThan(root.<Float>get(field),(Float)value));
							break;
						case LESS_THAN:
							predicates.add(cb.lessThan(root.<Float>get(field),(Float)value));
							break;
						case EQUAL:
							predicates.add(cb.equal(root.<Float>get(field),(Float)value));
	                        break;
					}
					break;
				case "fecha":
					String fechaCondition=(String) conditions.get("fechaCondicion");					
					switch (fechaCondition)
					{
						case GREATER_THAN:
							predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
							break;
						case LESS_THAN:
							predicates.add(cb.lessThan(root.<Date>get(field),(Date)value));
							break;
						case EQUAL:
							predicates.add(cb.equal(root.<Date>get(field),(Date)value));
	                        break;
					}
					break;
				}
			}); 
			query.where(cb.and(predicates.toArray( new Predicate[predicates.size()])));
				
			List<Pedido> result = entityManager.createQuery(query).setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
			
			CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
		    Root<Pedido> pedidosRootCount = countQuery.from(Pedido.class);
		    countQuery.select(cb.count(pedidosRootCount)).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
		    
		    
		    Long count = entityManager.createQuery(countQuery).getSingleResult();
			Page<Pedido> result1 = new PageImpl<>(result, pageable, count);
		    return  result1;
	}

	@Transactional(readOnly=true)
	@Override
	public int countPedido() {
		return (int) pedidoDao.count();
	}

}
