package com.movie.models.services;

import java.util.List;

import com.movie.models.entity.Usuario;

public interface IUsuarioService {

	//	obtener todos los isuarios
	public List<Usuario> findAll();
	
	//	obtener un usuario por id
	public Usuario findById(Long id);
	
	
	//	crear un nuevo usuario
	public Usuario save(Usuario usuario);
	
	public Usuario login(String username, String password);
}
