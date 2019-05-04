package com.the_humble_fool.PokeGoApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication

public class PokeGoApiApplication extends SpringBootServletInitializer
{

    @Value(value = "${spring.datasource.driver-class-name}")
    private String driverClass;

    @Value(value = "${spring.datasource.url}")
    private String url;

    @Value(value = "${spring.datasource.username}")
    private String username;

    @Value(value = "${spring.datasource.password}")
    private String password;

    @Value(value = "${spring.jpa.properties.hibernate.dialect}")
    private String dialect;

    @Value(value = "${spring.jpa.hibernate.ddl-auto}")
    private String hbm2ddl_auto;

    @Value(value = "${spring.jpa.show-sql}")
    private String show_sql;

    @Value(value = "${spring.jpa.format-sql}")
    private String format_sql;

    public static void main(String[] args)
    {
        SpringApplication.run(PokeGoApiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        return builder.sources(PokeGoApiApplication.class);
    }
    
    

    @Bean
    public JdbcTemplate jdbcTemplate()
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public DriverManagerDataSource dataSource()
    {
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName(driverClass);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);

        return ds;
    }

//    @Bean
//    public LocalSessionFactoryBean entityManagerFactory()
//    {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource());
//
//        Properties props = new Properties();
//        props.setProperty(Environment.DIALECT, dialect);
//        props.setProperty(Environment.HBM2DDL_AUTO, hbm2ddl_auto);
//        props.setProperty(Environment.SHOW_SQL, show_sql);
//        props.setProperty(Environment.FORMAT_SQL, format_sql);
//
//        sessionFactoryBean.setHibernateProperties(props);
//
//        sessionFactoryBean.setAnnotatedClasses(RaidBossEntityModel.class);
//        sessionFactoryBean.setAnnotatedClasses(EggPoolEntityModel.class);
//        sessionFactoryBean.setAnnotatedClasses(ResearchBreakthroughEncountersEntityModel.class);
//        sessionFactoryBean.setAnnotatedClasses(TypeWeatherBoostEntityModel.class);
//        sessionFactoryBean.setAnnotatedClasses(TypeEffectivenessEntityModel.class);
//        sessionFactoryBean.setAnnotatedClasses(UsersEntityModel.class);
//        sessionFactoryBean.setAnnotatedClasses(UserRolesEntityModel.class);
//        return sessionFactoryBean;
//    }
//
//    @Bean
//    public HibernateTemplate hibernateTemplate()
//    {
//        HibernateTemplate hibernateTemplate = new HibernateTemplate();
//        hibernateTemplate.setSessionFactory(entityManagerFactory().getObject());
//        return hibernateTemplate;
//    }

}
