package com.pasta.aglioeolio.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(value="com.pasta.aglioeolio.*.dao", sqlSessionFactoryRef="aglioSqlSessionFactory")
public class AglioDbConfig {

    @Primary
    @Bean(name="aglioDataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource aglioDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "aglioSqlSessionFactory")
    public SqlSessionFactory aglioSqlSessionFactory(@Qualifier("aglioDataSource") DataSource aglioDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(aglioDataSource);
        // mybatis 사용시 resources > aglioSql 폴더밑에 OO.xml 생성 후 주석 해제
//        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:aglioSql/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name="aglioSqlSessionTemplate")
    public SqlSessionTemplate apiSqlSessionTemplate(SqlSessionFactory aglioSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(aglioSqlSessionFactory);
    }

    @Primary
    @Bean( name = "aglioJpaEntityManagerFactory" )
    public LocalContainerEntityManagerFactoryBean jpaEntityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("aglioDataSource") DataSource dataSource ) {
        return builder.dataSource(dataSource).packages("com.pasta.aglioeolio.config.jpa").build();
    }

    @Primary
    @Bean(name = "aglioTransactionManager")
    public JpaTransactionManager transactionManager(
        @Qualifier("aglioJpaEntityManagerFactory") LocalContainerEntityManagerFactoryBean mfBean
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory( mfBean.getObject() );
        return transactionManager;
    }
}