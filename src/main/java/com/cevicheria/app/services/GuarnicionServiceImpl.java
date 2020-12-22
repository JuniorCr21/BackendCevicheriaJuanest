package com.cevicheria.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cevicheria.app.models.dao.IGuarnicionDao;
import com.cevicheria.app.models.entity.Guarnicion;

@Service
public class GuarnicionServiceImpl implements IGuarnicionService{

	@Autowired
	private IGuarnicionDao guarnicionDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Guarnicion> findAll() {
		return guarnicionDao.findAll();
	}

	@Transactional
	@Override
	public Guarnicion save(Guarnicion guarnicion) {
		return guarnicionDao.save(guarnicion);
	}

	@Transactional(readOnly = true)
	@Override
	public Guarnicion findById(Long id) {
		return guarnicionDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		guarnicionDao.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Long count() {
		return guarnicionDao.count();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Guarnicion> customGuarnicionQuery(boolean estado) {
		return guarnicionDao.customGuarnicionQuery(estado);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Guarnicion> findByNombreIgnoreCaseContaining(String cadena) {
		return guarnicionDao.findByNombreIgnoreCaseContaining(cadena);
	}

}
