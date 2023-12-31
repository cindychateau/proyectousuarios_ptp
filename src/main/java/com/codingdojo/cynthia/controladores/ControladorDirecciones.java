package com.codingdojo.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.cynthia.modelos.Direccion;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.Servicios;

import jakarta.validation.Valid;

@Controller
public class ControladorDirecciones {
	
	@Autowired
	private Servicios servicio;
	
	@GetMapping("/direcciones/nueva")
	//ModelAttribute: envía objeto vacío para que se llene con el form
	//Model model: envía info de mi método a mi jsp
	public String nuevaDireccion(@ModelAttribute("direccion") Direccion direccion,
								 Model model) {
		
		List<Usuario> listaUsuarios = servicio.usuariosSinDireccion();
		model.addAttribute("usuarios", listaUsuarios);
		
		return "/direcciones/nueva.jsp";
	}
	
	@PostMapping("/direcciones/crear")
	public String crearDireccion(@Valid @ModelAttribute("direccion") Direccion direccion,
								 BindingResult result,
								 Model model) {
		
		if(result.hasErrors()) {
			//Enviar toda la info necesaria para mi formulario
			List<Usuario> listaUsuarios = servicio.usuariosSinDireccion();
			model.addAttribute("usuarios", listaUsuarios);
			return "/direcciones/nueva.jsp";
		} else {
			servicio.guardarDireccion(direccion);
			return "redirect:/dashboard";
		}
		
	}
	
}
