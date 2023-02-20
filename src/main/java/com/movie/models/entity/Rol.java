package com.movie.models.entity;

import java.io.Serializable;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Rol implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_rol;
	
	@Column(nullable = false, unique = true)
	private String rol;
	
	public Long getId_rol() {
		return id_rol;
	}
	public void setId_rol(Long id_rol) {
		this.id_rol = id_rol;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}

	private static final long serialVersionUID = 1L;
	
}
