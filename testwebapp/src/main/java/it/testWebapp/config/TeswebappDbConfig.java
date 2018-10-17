package it.testWebapp.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import it.testWebapp.model.User;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "testwebappEntityManager", 
		transactionManagerRef = "testwebappTransactionManager", 
		basePackages = "it.testWebapp.mysql.dao")
public class TeswebappDbConfig {
	/**
	 * Mysql datasource definition.
	 * 
	 * @return datasource.
	 */
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.first.datasource")
	public DataSource testwebappDataSource() {
		
		DataSource dataSource = DataSourceBuilder.create().build();
		
		return dataSource;
	}
	
	/**
	 * Entity manager definition. 
	 *  
	 * @param builder an EntityManagerFactoryBuilder.
	 * @return LocalContainerEntityManagerFactoryBean.
	 */
	@Primary
	@Bean(name = "testwebappEntityManager")
	public LocalContainerEntityManagerFactoryBean testwebappEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
					.dataSource(testwebappDataSource())
					.properties(hibernateProperties())
					.packages(User.class)
					.persistenceUnit("testwebappPU")
					.build();
	}
	
	@Primary
	@Bean(name = "testwebappTransactionManager")
	public PlatformTransactionManager testwebappTransactionManager(@Qualifier("testwebappEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	private Map<String, Object> hibernateProperties() {
		 
		Resource resource = new ClassPathResource("hibernate.properties");
		
		try {
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			return properties.entrySet().stream()
											.collect(Collectors.toMap(
														e -> e.getKey().toString(),
														e -> e.getValue())
													);
		} catch (IOException e) {
			return new HashMap<String, Object>();
		}
	}
}
