package com.zyt.orz.config.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

@Configuration
@MapperScan(basePackages = "com.zyt.orz.mapper", sqlSessionFactoryRef = "sqlSessionFactoryDB1")
public class DB1DataSourceConfig {

	@Primary
	@Bean(name = "dataSourceDB1")
	@ConfigurationProperties(prefix = "spring.datasource.db1")
	public DataSource getDateSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean("sqlSessionFactoryDB1")
	public SqlSessionFactory getSqlSessionfactory(@Qualifier("dataSourceDB1") DataSource dataSource) throws Exception {

		MybatisConfiguration conf = new MybatisConfiguration();
		conf.setMapUnderscoreToCamelCase(true);
		// mybatis-plus 分页插件生效
		conf.addInterceptor(new PaginationInterceptor());

		MybatisSqlSessionFactoryBean beanp = new MybatisSqlSessionFactoryBean();
		beanp.setDataSource(dataSource);
		beanp.setConfiguration(conf);
		beanp.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
		return beanp.getObject();
	}

	@Primary
	@Bean("sqlSessionTemplateDB1")
	public SqlSessionTemplate getSqlSessionTemplate(
			@Qualifier("sqlSessionFactoryDB1") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
