package com.fxtcn.platform.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.fxtcn.platform.config.properties.CommonDataSourceConfigProperty;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
@Configuration
public class CommonConfig {
	@Autowired
	private DataSourceConfig dataSourceConfig;
	@Autowired
	private CommonDataSourceConfigProperty commonDataSourceConfig;
	@Primary
	public DataSource DataSource() {
		DruidDataSource ds=new DruidDataSource();
		ds.setUrl(dataSourceConfig.getUrl());
		ds.setUsername(dataSourceConfig.getUsername());
		ds.setPassword(dataSourceConfig.getPassword());
		ds.setDriverClassName(dataSourceConfig.getDriverClassName());
		
		ds.setInitialSize(commonDataSourceConfig.getInitialSize());
		ds.setMinIdle(commonDataSourceConfig.getMinIdle());
		ds.setMaxActive(commonDataSourceConfig.getMaxActive());
		ds.setTestOnBorrow(commonDataSourceConfig.isTestOnReturn());
		ds.setTestOnReturn(commonDataSourceConfig.isTestOnReturn());
		ds.setMinEvictableIdleTimeMillis(commonDataSourceConfig.getMinEvictableIdleTimeMillis());
		return ds;
	}
	
	@Bean
	public DataSourceTransactionManager  dataSourceTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Bean(name="sqlSessionFactory")
	@Primary
	public SqlSessionFactory SqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
		
		sessionFactoryBean.setDataSource(dataSource);
		
		Resource resource = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml");
		sessionFactoryBean.setConfigLocation(resource);
		
//		Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources
//				("classpath:mybatis/mybatis-config.xml");
//		sessionFactoryBean.setMapperLocations(mapperLocations);
		return sessionFactoryBean.getObject();
	}
	
	@Bean(name="sqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory")SqlSessionFactory sqlSessionFactory) {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		return sqlSessionTemplate;
	}
	
	
}
