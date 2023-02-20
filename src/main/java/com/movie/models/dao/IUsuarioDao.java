package com.movie.models.dao;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.movie.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	
	@Query("select u from Usuario u where u.nombre_usuario=?1 and u.password=?2")
	public Usuario login( String username, String password);
	
}
