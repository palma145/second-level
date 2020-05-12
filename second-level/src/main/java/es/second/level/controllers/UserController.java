package es.second.level.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.second.level.dtos.UserDto;
import es.second.level.services.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "all", produces = "application/json")
	public List<UserDto> getAllUsers(){
		
		log.info("*** Recuperamos todos los usuarios");
		return userService.getAllUsers();
	}
	
	@GetMapping(value = "{username}", produces = "application/json")
	public UserDto getUserById(@PathVariable(value = "username") String username){
		
		log.info("*** Recuperamos el usuario :: "+ username);
		return userService.getUserById(username);
	}
}
