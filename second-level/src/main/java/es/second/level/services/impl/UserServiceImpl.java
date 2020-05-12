package es.second.level.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.second.level.dtos.UserDto;
import es.second.level.entities.UserEntity;
import es.second.level.repositories.UserRepository;
import es.second.level.services.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto getUserById(String username) {
				
		log.info("*** Buscamos el usuario :: "+ username);
		Optional<UserEntity> entity = userRepository.findById(username);
		
		if(entity.isPresent()) {
			return new DozerBeanMapper().map(entity.get(), UserDto.class);
		}
		
		return null;
	}
	
	@Override
	public List<UserDto> getAllUsers() {
				
		log.info("*** Buscamos todos los usuarios");
		List<UserEntity> entities = userRepository.findAllCache();
		
		if(entities != null & !entities.isEmpty()) {
			
			DozerBeanMapper mapper = new DozerBeanMapper();
			
			List<UserDto> users = new ArrayList<>();	
			for(UserEntity entity:entities) {
				users.add(mapper.map(entity, UserDto.class));
			}
			
			return users;
		}
		
		return new ArrayList<>();
	}
}
