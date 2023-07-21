package com.care.ajaxBasic.config;

import java.io.IOException;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@MapperScan(basePackages = {"com.care.ajaxBasic"})
@Configuration
public class DatabaseConfig {

	@Bean
	public HikariDataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hikariConfig.setUsername("oracle");
		hikariConfig.setPassword("oracle");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean sessionFactory() throws IOException {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		
		PathMatchingResourcePatternResolver resolver = 
				new PathMatchingResourcePatternResolver();

		sessionFactory.setMapperLocations(resolver.getResources("classpath:mappers/**/*Mapper.xml"));
		return sessionFactory;
	}
}

// spring bean configuration file 로 만든후
/*
 * <!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
<mapper namespace="com.care.ajaxBasic.MemberMapper">
</mapper>

이 독타입을 넣어줘야함
 * */
