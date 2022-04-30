package cl.desafiolatam.administracionbodega.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cl.desafiolatam.administracionbodega.app.repository.model.Users;

public interface UsersRepository extends CrudRepository<Users, Integer>{
	public List<Users> findByEmail(String email);
}
