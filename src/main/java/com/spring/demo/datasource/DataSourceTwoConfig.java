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
//@MapperScan(basePackages = "com.spring.demo.mapper", sqlSessionFactoryRef = "twoSqlSessionFactory")
public class DataSourceTwoConfig {
    //@Autowired
    private DBTwoConfig dbTwoConfig;

    //@Bean(name = "twoDataSource")
    public DataSource getDateSourceTwo() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dbTwoConfig.getUrl());
        dataSource.setName(dbTwoConfig.getUsername());
        dataSource.setUsername(dbTwoConfig.getUsername());
        dataSource.setPassword(dbTwoConfig.getPassword());
        dataSource.setDriverClassName(dbTwoConfig.getDriverClassName());
        return dataSource;
    }

    //@Bean(name = "twoSqlSessionFactory")
    public SqlSessionFactory twoSqlSessionFactory(DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/two/BootUserTwoMapper.xml"));
        return bean.getObject();
    }
    //@Bean("twoSqlSessionTemplate")
    public SqlSessionTemplate twosqlsessiontemplate(
            @Qualifier("twoSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
