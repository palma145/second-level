package es.second.level.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.second.level.dtos.ProductoDto;
import es.second.level.entities.ProductoEntity;
import es.second.level.repositories.ProductoRepository;
import es.second.level.services.ProductoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
		
	@Override
	public List<ProductoDto> getAllProductos() {
				
		log.info("*** Buscamos todos los productos");
		List<ProductoEntity> entities = productoRepository.findAllCache();
		
		if(entities != null & !entities.isEmpty()) {
			
			DozerBeanMapper mapper = new DozerBeanMapper();
			
			List<ProductoDto> users = new ArrayList<>();	
			for(ProductoEntity entity:entities) {
				users.add(mapper.map(entity, ProductoDto.class));
			}
			
			return users;
		}
		
		return new ArrayList<>();
	}

	@Override
	public ProductoDto saveAndUpdate(ProductoDto dtoSaveAndUpdate) {

		DozerBeanMapper mapper = new DozerBeanMapper();
		
		if(dtoSaveAndUpdate.getId() == null) {
			
			dtoSaveAndUpdate.setId(UUID.randomUUID().toString());
			log.info("*** Guardamos el producto "+ dtoSaveAndUpdate.getId());
			
			productoRepository.save(mapper.map(dtoSaveAndUpdate, ProductoEntity.class));
			return dtoSaveAndUpdate;
			
		}
		
		log.info("*** Actualizamos el producto "+ dtoSaveAndUpdate.getId());
		productoRepository.save(mapper.map(dtoSaveAndUpdate, ProductoEntity.class));
			
		return dtoSaveAndUpdate;
	}

	@Override
	public ProductoDto delele(ProductoDto dtoDelete) {
		
		DozerBeanMapper mapper = new DozerBeanMapper();
		
		log.info("*** Borramos el producto "+ dtoDelete.getId());
		productoRepository.delete(mapper.map(dtoDelete, ProductoEntity.class));

		return dtoDelete;
	}
}
