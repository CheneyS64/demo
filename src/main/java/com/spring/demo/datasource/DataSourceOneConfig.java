package com.spring.demo.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

//@Configuration
//@MapperScan(basePackages = "com.spring.demo.mapper", sqlSessionFactoryRef = "oneSqlSessionFactory")
public class DataSourceOneConfig {

    //@Autowired
    private DBOneConfig dbOneConfig;

    //@Bean(name = "oneDataSource")
    public DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dbOneConfig.getUrl());
        dataSource.setName(dbOneConfig.getUsername());
        dataSource.setUsername(dbOneConfig.getUsername());
        dataSource.setPassword(dbOneConfig.getPassword());
        dataSource.setDriverClassName(dbOneConfig.getDriverClassName());
        return dataSource;
    }

    //@Bean(name = "oneSqlSessionFactory")
    public SqlSessionFactory oneSqlSessionFactory(DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/one/BootUserOneMapper.xml"));
        return bean.getObject();
    }

    //@Bean("oneSqlSessionTemplate")
    public SqlSessionTemplate onesqlsessiontemplate(
            @Qualifier("oneSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
