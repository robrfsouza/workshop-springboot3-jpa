package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

/*Para que essa classe seja implementada como um recurso web
 * que é implementado por um controlador rest, é necessário 
 * colocar um anotation
 */
@RestController

/*Colocar o nome para o recurso
 * 
 */
@RequestMapping(value = "/products")

public class ProductResource {
	
	@Autowired
	private ProductService service;

	/*ResponseEntity é um tipo específico do Spring para restornar respostas de requisicoes web
	 * 
	 */
	/*Para indicar que esse método vai ser o método que responde a requisicao do tipo Get do http
	 * vou colocar um anotation chamado GetMapping
	 */
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){

		List<Product> list = service.findAll();
		//para retornar a responsa com sucesso no http (ResponseEntity.ok)
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product product = service.findById(id);
		return ResponseEntity.ok().body(product);
		
	}
}
