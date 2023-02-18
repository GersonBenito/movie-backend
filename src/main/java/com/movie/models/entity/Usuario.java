package com.movie.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	private Long id_usuario;
	private Long id_rol;
	private String nombre_usuario;
	private String email;
	private String password;
}
