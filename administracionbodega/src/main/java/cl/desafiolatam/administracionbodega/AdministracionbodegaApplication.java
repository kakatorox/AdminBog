package cl.desafiolatam.administracionbodega;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import cl.desafiolatam.administracionbodega.app.repository.RoleRepository;
import cl.desafiolatam.administracionbodega.app.repository.UsersRepository;
import cl.desafiolatam.administracionbodega.app.repository.model.Role;
import cl.desafiolatam.administracionbodega.app.repository.model.Users;

@SpringBootApplication
public class AdministracionbodegaApplication {
private final static Logger logger= LoggerFactory.getLogger(ServletInitializer.class);
	
	@Autowired
	UsersRepository usersRepository; 
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(AdministracionbodegaApplication.class, args);
	}

	@Bean
	public CommandLineRunner createUsuario() {
		return (args) -> {
			
			Role rol1= new Role();
			rol1.setTipo("ADMIN");
			roleRepository.save(rol1);
			
			Role rol2= new Role();
			rol2.setTipo("CLIENT");		
			roleRepository.save(rol2);
			
			Users usuario1 = new Users();
			
			usuario1.setEmail("k@s.com");			
			usuario1.setPassword(passwordEncoder.encode("1234"));
			usuario1.setRole(rol1);			
			usersRepository.save(usuario1);
			
			Users usuario2 = new Users();
			
			usuario2.setEmail("q@s.com");			
			usuario2.setPassword(passwordEncoder.encode("1234"));
			usuario2.setRole(rol2);
			usersRepository.save(usuario2);
			
			
			
			
			logger.info(usuario1.toString());
			logger.info(usuario2.toString());
		};
	}
}
