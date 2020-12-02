package com.xx.readwrite.config.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author linkuan
 * @version 1.0
 * @since 2020/12/2 16:33
 */
@Configuration
@MapperScan(basePackages = "com.xx.readwrite.dao",
        sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("routingDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        // 配置 Mybatis mapper文件的配置
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath*:mybatis/mapper/*.xml"));
        return bean.getObject();
    }

    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate masterSqlSessionTemplate(
            @Qualifier("sqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
