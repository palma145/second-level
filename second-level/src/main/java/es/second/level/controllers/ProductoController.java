package es.second.level.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.second.level.dtos.ProductoDto;
import es.second.level.services.ProductoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductoDto createProducto(@RequestBody ProductoDto producto) {
		
		log.info("*** Creando producto :: "+ producto);
		return productoService.saveAndUpdate(producto);
	}
	
	@GetMapping(value = "read", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductoDto> readProducto() {
		
		log.info("*** Devolviendo productos");
		return productoService.getAllProductos();
	}
	
	@PutMapping(value = "edit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductoDto putProducto(@RequestBody ProductoDto producto) {
		
		log.info("*** Actualizando producto");	
		return productoService.saveAndUpdate(producto);
	}
	
	@DeleteMapping(value = "delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductoDto deleteProducto(@RequestBody ProductoDto producto) {
		
		log.info("*** Borrando producto");
		return productoService.delele(producto);
	}
}