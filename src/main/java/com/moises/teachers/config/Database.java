package com.moises.teachers.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class Database {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(getDataSource());
	      em.setPackagesToScan(new String[] { "com.moises.teachers.model" });     
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      return em;
	 }
	
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/teachers");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	
	public Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("show_sql", "true");
		return properties;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
	       JpaTransactionManager transactionManager = new JpaTransactionManager();
	       transactionManager.setEntityManagerFactory(emf);
	       return transactionManager;
	}
	 
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
		return new PersistenceExceptionTranslationPostProcessor();
	}
	   
	/*
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan("com.moises.teachers.model");
		sessionFactory.setHibernateProperties(getProperties());
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}*/
}
