package com.movie.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.models.entity.Usuario;
import com.movie.models.services.IUsuarioService;

@RestController
@RequestMapping("/api/v1")
public class UsuarioRestControllers {

	@Autowired
	private IUsuarioService usuarioService;

	// obtener todos los usuarios
	@GetMapping("/usuario")
	public List<Usuario> findAll() {
		return usuarioService.findAll();
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {

		Usuario usuario = null;
		Map<String, Object> response = new HashMap<>();

		try {

			usuario = usuarioService.findById(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al obtener el usuario");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (usuario == null) {
			response.put("mensaje", "Usuario con el id ".concat(id.toString().concat(" no existe")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Usuario usuario) {

		Usuario usuarioLogin = null;
		Map<String, Object> response = new HashMap<>();

		try {

			usuarioLogin = usuarioService.login(usuario.getNombre_usuario(), usuario.getPassword());
			response.put("mensaje", "Usuario logueado correctamente");
			response.put("data", usuarioLogin);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al loguearse");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (usuarioLogin == null) {
			response.put("mensaje", "Usuario o contraseña no valido");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/usuario")
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {

		Usuario usuarioNuevo = null;
		Map<String, Object> response = new HashMap<>();

		try {
			usuarioNuevo = usuarioService.save(usuario);
			response.put("mensaje", "Usuario agregado correctamente");
			response.put("data", usuarioNuevo);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		} catch (DataAccessException e) {

			response.put("mensaje", "Error al agregar un nuevo usuario");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
