package com.zendy.study;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DaoFactory {
	
	@Bean
	public UserDAO userDao() {
		return new UserDAO(dataSource());
	}
	
	@Bean
	public ConnectionMaker getConnectionMaker() {
		return new SimpleConnectionMaker();
	}
	
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(org.mariadb.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost/zendy");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		return dataSource;
	}
}
