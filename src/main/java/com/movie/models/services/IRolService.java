package com.movie.models.services;

import java.util.List;

import com.movie.models.entity.Rol;

public interface IRolService {
	
	// metodo para obtener todos los roles
	public List<Rol> findAll();
	
	// metodo para crear un nuevo rol
	public Rol save(Rol rol);
	
}
