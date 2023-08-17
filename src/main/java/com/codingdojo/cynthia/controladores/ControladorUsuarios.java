package com.codingdojo.cynthia.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorUsuarios {
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
}
