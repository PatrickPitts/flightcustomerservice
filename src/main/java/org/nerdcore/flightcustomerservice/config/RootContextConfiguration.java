package org.nerdcore.flightcustomerservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@EntityScan("org.nerdcore.flightcustomerservice.entities")
public class RootContextConfiguration {

//    @Autowired
//    private Environment env;
//    @Bean
//    public DataSource flightCustomerServiceDataSource(){
//        return (new JndiDataSourceLookup()).getDataSource(env.getProperty("jndiName"));
//    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("MySQLPass");
        dataSource.setUrl("jdbc:mysql://localhost:3306/flightcustomerservice?createDatabaseIfNotExist=true");
        return dataSource;
    }



    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        Map<String, Object> properties = new Hashtable<>();
        //properties.put("hibernate.hbm2ddl.auto", "none");


        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(this.dataSource());
        factoryBean.setJpaVendorAdapter(adapter);
        factoryBean.setJpaPropertyMap(properties);
        factoryBean.setPackagesToScan("org.nerdcore.flightcustomerservice.entities");
        return factoryBean;
    }
}
