package cl.desafiolatam.administracionbodega.app.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.desafiolatam.administracionbodega.app.repository.UsersRepository;
import cl.desafiolatam.administracionbodega.app.repository.model.Users;

@Service
public class AuthServiceImpl implements UserDetailsService{

	@Autowired
	private UsersRepository usersRepository; 
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<Users> listUsers = usersRepository.findByEmail(username);
		Users users = null;
		UserBuilder userBuilder = null;
		if(listUsers == null || listUsers.size() != 1) {
			throw new UsernameNotFoundException(username);
		}else {
			users = listUsers.get(0);			
			httpSession.setAttribute("usuarioConectado", users.getEmail());
			userBuilder = User.withUsername(username);
			userBuilder.password(users.getPassword());
			//userBuilder.password(new BCryptPasswordEncoder().encode(usuario.getPassword()));
			String[] roles = {users.getRole().getTipo()};
			userBuilder.roles(roles);			
		}
		return userBuilder.build();
	}
}
