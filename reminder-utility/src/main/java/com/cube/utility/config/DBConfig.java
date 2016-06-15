/*package com.cube.utility.config;

import java.util.HashMap;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "baseEntityManagerFactory", transactionManagerRef = "baseTransactionManager", basePackages = { "com.cube.utility.repositories" })
public class DBConfig {

	@Value("${app.connection.pool.config}")
	private String environment;

	@Value("${app.db.citruscubebase}")
	private String baseDbLookup;

	@Profile("development")
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}

	@Profile("development")
	@Bean(name = "baseDataSource")
	@Primary
	@ConfigurationProperties(prefix = "datasource.primary")
	public DataSource dataSource() throws NamingException {
		if (environment != null
				&& environment.toString().equalsIgnoreCase("ON")) {
			JndiTemplate jndiTemplate = new JndiTemplate();
			return (DataSource) jndiTemplate.lookup(baseDbLookup);
		} else {
			return new DriverManagerDataSource();
		}
	}

	@Bean(name = "baseEntityManager")
	public EntityManager entityManager() throws NamingException {
		return entityManagerFactory().createEntityManager();
	}

	@Profile("development")
	@Bean(name = "baseEntityManagerFactory")
	public EntityManagerFactory entityManagerFactory() throws NamingException {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource());
		lef.setJpaVendorAdapter(jpaVendorAdapter());
		lef.setPersistenceProviderClass(HibernatePersistence.class);
		lef.setPackagesToScan("com.cube.utility.entities");
		lef.setPersistenceUnitName("basePersistenceUnit");
		lef.setJpaPropertyMap(propertiesMap());
		lef.afterPropertiesSet();
		return lef.getObject();
	}

	@Bean(name = "baseTransactionManager")
	public PlatformTransactionManager transactionManager()
			throws NamingException {
		return new JpaTransactionManager(entityManagerFactory());
	}

	private HashMap<String, Object> propertiesMap() {
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.ejb.naming_strategy",
				"org.hibernate.cfg.ImprovedNamingStrategy");

		return properties;
	}
}
*/