package es.second.level.services;

import java.util.List;

import es.second.level.dtos.ProductoDto;

public interface ProductoService {

	List<ProductoDto> getAllProductos();
	
	ProductoDto saveAndUpdate(ProductoDto dtoSave);
	
	ProductoDto delele(ProductoDto dtoDelete);
}
