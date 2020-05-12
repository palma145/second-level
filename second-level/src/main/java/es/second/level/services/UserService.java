package es.second.level.services;

import java.util.List;

import es.second.level.dtos.UserDto;

public interface UserService {

	UserDto getUserById(String username) ;
	List<UserDto> getAllUsers();
}
