package cl.desafiolatam.administracionbodega.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class DataBaseConf {

	@Autowired
	Environment enviroment;
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(enviroment.getProperty("pg.driver"));
		driverManagerDataSource.setUrl(enviroment.getProperty("pg.datasource.url"));
		driverManagerDataSource.setUsername(enviroment.getProperty("pg.datasource.username"));
		driverManagerDataSource.setPassword(enviroment.getProperty("pg.datasource.password"));
		return driverManagerDataSource;
	}
}
