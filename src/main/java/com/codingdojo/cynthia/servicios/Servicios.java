package com.codingdojo.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	
	@Autowired //No es una instancia
	private RepositorioUsuarios repoUsuarios;
	
	
	//Me regrese una lista con todos los usuarios
	public List<Usuario> todosUsuarios() {
		return repoUsuarios.findAll();
	}
	
	//Guardamos un usuarios
	public Usuario guardarUsuario(Usuario nuevoUsuario) {
		return repoUsuarios.save(nuevoUsuario);
	}
	
	//Me regresara un usuario en base a su ID
	public Usuario buscarUsuario(Long id) {
		//SELECT * FROM usuarios WHERE id = <id>
		return repoUsuarios.findById(id).orElse(null); 
		//Me regresa un usuario y si no lo encuentra null
	}
	
	//Borre un usuario en base a su ID
	public void borrarUsuario(Long id) {
		repoUsuarios.deleteById(id); //DELETE FROM usuarios WHERE id = <id>
	}
	
}
