package com.codingdojo.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.Servicios;

@RestController
public class ControladorAPI {
	
	@Autowired
	private Servicios servicio;
	
	@GetMapping("/api/usuarios")
	public List<Usuario> apiMuestraUsuarios() {
		return servicio.todosUsuarios();
	}
	
	@PostMapping("/api/usuarios")
	public Usuario apiCrearUsuario(@RequestParam("nombre") String nombre,
								   @RequestParam("apellido") String apellido,
								   @RequestParam("email") String email,
								   @RequestParam("password") String password) {
		
		
		Usuario nuevoUsuario = new Usuario(nombre, apellido, email, password);
		return servicio.guardarUsuario(nuevoUsuario);
		
	}
	
	@DeleteMapping("/api/usuarios/{id}")
	public void apiBorrar(@PathVariable("id") Long id) {
		servicio.borrarUsuario(id);
	}
	
}
