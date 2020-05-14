package es.second.level.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "productos")
public class JspProductoController {

	@GetMapping(value = "view")
	public String getViewProductos() {
		
		log.info("*** Cargando productos_view.jsp");
		return "productos_view";
	}
}