package com.movie.models.services;

import java.util.List;import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.models.dao.IUsuarioDao;
import com.movie.models.entity.Usuario;

//decoramos como un servicio
@Service
public class UsuarioServiceImplement implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll(){
		return (List<Usuario>) usuarioDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario login(String username, String password) {
		
		return usuarioDao.login(username, password);
	}
}
