package com.movie.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.movie.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

}
