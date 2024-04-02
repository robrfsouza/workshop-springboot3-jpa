package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

/*Para que essa classe seja implementada como um recurso web
 * que é implementado por um controlador rest, é necessário 
 * colocar um anotation
 */
@RestController

/*Colocar o nome para o recurso
 * 
 */
@RequestMapping(value = "/users")

public class UserResource {
	
	@Autowired
	private UserService service;

	/*ResponseEntity é um tipo específico do Spring para restornar respostas de requisicoes web
	 * 
	 */
	/*Para indicar que esse método vai ser o método que responde a requisicao do tipo Get do http
	 * vou colocar um anotation chamado GetMapping
	 */
	@GetMapping
	public ResponseEntity<List<User>> findAll(){

		List<User> list = service.findAll();
		//para retornar a responsa com sucesso no http (ResponseEntity.ok)
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(user);
		
	}
}
