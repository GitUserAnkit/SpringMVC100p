package com.ankit.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
@ComponentScan(basePackages="com.ankit.dao")
public class PersistenceConfig {
   @Bean
   public DataSource createJDSL() {
	   //get the datasource from jndi registry
	   JndiDataSourceLookup jdsl=null;
	   DataSource ds=null;
	   jdsl=new JndiDataSourceLookup();
	   ds=jdsl.getDataSource("java:/comp/env/DsJndi");
	   return ds;
   }
   @Bean
   public JdbcTemplate creatJT() {
	   JdbcTemplate jt=null;
	   jt=new JdbcTemplate(createJDSL());
	   return jt;
   }
   
}
