package cl.desafiolatam.administracionbodega.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cl.desafiolatam.administracionbodega.app.repository.model.Role;
import cl.desafiolatam.administracionbodega.app.repository.model.Users;

public interface RoleRepository extends CrudRepository<Role, Integer>{
	public List<Role> findByTipo(String tipo);
}
