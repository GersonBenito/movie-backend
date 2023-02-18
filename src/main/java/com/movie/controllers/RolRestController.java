package com.movie.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.models.entity.Rol;
import com.movie.models.services.IRolService;

@RestController
@RequestMapping("/api/v1")
public class RolRestController {
	
	@Autowired
	private IRolService rolService;
	
	// obtenemos roles
	@GetMapping("/rol")
	public List<Rol> getRoles(){
		
		return rolService.findAll();
		
	}
	
	// agregar nuevo rol
	@PostMapping("/rol")
	public ResponseEntity<?> create(@RequestBody Rol rol) {
		
		Rol rolNew = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			rolNew = rolService.save(rol);
			response.put("mensaje", "Rol agregado exitosamente");
			response.put("data", rolNew);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			
		}catch (DataAccessException e) {
			// mostramos el mensaje de error o la causa de ese error
			response.put("mensaje", "Error al agregar el Rol");
			response.put("error", e.getMessage()
					.concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			// retornamos el codigo de estado de ese error
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
