 package cl.desafiolatam.administracionbodega.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import cl.desafiolatam.administracionbodega.app.service.impl.AuthServiceImpl;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		
//		auth.inMemoryAuthentication().withUser("bodegon")
//									.password(passwordEncoder().encode("1234"))
//									.roles("BODEGA");
//		auth.inMemoryAuthentication().withUser("bodegin")
//									.password(passwordEncoder().encode("1234"))
//									.roles("BODEGA");
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests()
													 .antMatchers("/material/**").hasAnyRole("ADMIN","CLIENT")
													 .antMatchers("/login").permitAll()
													 .anyRequest()
													 .authenticated()
													 .and()
													 .formLogin()
													 .loginPage("/login")
													 .successHandler(customAthenticationSuccessHandler())
													 .failureUrl("/login?error=true")
													 .usernameParameter("username")
													 .passwordParameter("password")
													 .and()
													 .exceptionHandling()
													 .accessDeniedPage("/recurso-prohibido");
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationSuccessHandler customAthenticationSuccessHandler() {
		return new CustomAutentificationSuccessHandler();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new AuthServiceImpl();
	}
}
