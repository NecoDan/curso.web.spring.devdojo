package br.com.curso.web.spring.devdojo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/*@Configuration
@EnableJpaRepositories(basePackages = "br.com.curso.web.spring.devdojo.repository", entityManagerFactoryRef = "dbEntityManager", transactionManagerRef = "dbTransactionManager")
@EnableTransactionManagement*/
public class DataBaseMySQLConfig {

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean dbEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dbDatasourceSecondary());
        em.setPackagesToScan(new String[]{"br.com.curso.web.spring.devdojo.model"});
        em.setPersistenceUnitName("dbEntityManager");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        HashMap<String, Object> properties = new HashMap<>();

        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show-sql", env.getProperty("jdbc.show-sql"));

        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    public DataSource dbDatasourceSecondary() {
        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("com.mysql.cj.jdbc.Driver"));
        dataSource.setUrl(env.getProperty("jdbc:mysql://localhost:3306/adota_pet"));
        dataSource.setUsername(env.getProperty("root"));
        dataSource.setPassword(env.getProperty("m4st3r.dan"));

        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager dbTransactionManager() {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                dbEntityManager().getObject());

        return transactionManager;
    }
}
