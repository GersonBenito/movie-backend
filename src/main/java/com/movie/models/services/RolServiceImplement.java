package com.movie.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.models.dao.IRolDao;
import com.movie.models.entity.Rol;

/**@Service marcamos esta clase como un componente de servicios en spring al igual que 
 * quedara en elcontexto de spring
 */
@Service
public class RolServiceImplement implements IRolService{

	@Autowired
	private IRolDao rolDao;
	
	/**Al ser solo un select se agrega que unicamente sera de lectura el @Transactional*/
	@Override
	@Transactional(readOnly = true)
	public List<Rol> findAll() {
		return (List<Rol>) rolDao.findAll();
	}
	
	@Override
	@Transactional
	public Rol save(Rol rol) {
		return rolDao.save(rol);
	}
	

}
