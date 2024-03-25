package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

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

	/*ResponseEntity é um tipo específico do Spring para restornar respostas de requisicoes web
	 * 
	 */
	/*Para indicar que esse método vai ser o método que responde a requisicao do tipo Get do http
	 * vou colocar um anotation chamado GetMapping
	 */
	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User (1L, "Maria", "maria@gmail.com", "21-9999-99999", "12345");
		
		//para retornar a responsa com sucesso no http (ResponseEntity.ok)
		return ResponseEntity.ok().body(user);
	}
}
