package com.mvc.config;

import java.util.Properties;

import javax.sql.DataSource;

//import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
import com.mvc.model.*;
import com.mvc.repository.*;
//import com.mvc.controller.*;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages ={"com.mvc"})

public class SpringUtil {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver ir = new InternalResourceViewResolver();
		ir.setPrefix("/WEB-INF/jsp/");
		ir.setSuffix(".jsp");
		return ir;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bookapplication");
		dataSource.setUsername("root");
		dataSource.setPassword("Bashokrish@123");
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		Properties properties = new Properties();
		properties.put("hibernate.SHOW_SQL", true);
		properties.put("hibernate.HBM2DDL_AUTO","update");
		properties.put("hibernate.DIALECT","org.hibernate.dialect.MySQL8Dialect");
		sessionFactory.setHibernateProperties(properties);
		sessionFactory.setAnnotatedClasses(Book.class,User.class);
		return sessionFactory;
	}

//    @Value("${spring.data.mongodb.database}")
//    private String databaseName;

//    @Value("${mongodb.collection.name}")
//    private String collectionName;

//    @Bean
//    public MongoCollection<Document> mongoCollection() {
//        return mongoTemplate().getCollection(collectionName);
//    }
	
	//working MongoClient 
	
//	@Bean
//    public MongoClient mongoClient() {
//        return MongoClients.create("mongodb://localhost:27017");
//    }
// 
//    @Bean
//    public MongoTemplate mongoTemplate() {
//        return new MongoTemplate(mongoClient(), "bookapplication");
//    }

	@Bean
	public BookRepository getBookRepository() {
		BookRepository bkr = new BookRepository();
		return bkr;
	}
	
	@Bean
	public UserRepository getUserRepository() {
		UserRepository ur = new UserRepository();
		return ur;
	}
	
	
}
