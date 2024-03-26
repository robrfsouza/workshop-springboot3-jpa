package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//Anotation para especificar que essa classe é de configuracao
@Configuration
//Para falar que essa classe é uma configuracao específica de test
@Profile("test")
public class TestConfig implements CommandLineRunner {

	/*Para que o spring consiga resolver essa dependencia e associar uma instancia
	 * do UserRepository no TestConfig, basta acrescentar a anotation
	 */
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));

	}
}
