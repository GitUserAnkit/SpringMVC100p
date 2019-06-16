package com.ankit.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


@Configuration
public class AopConfig {
	@Autowired
	private DataSource ds;
	
	@Bean(name="dsTxMgr")
    public DataSourceTransactionManager creatDSTM() {
    	DataSourceTransactionManager dsTxMgr=null;
    	dsTxMgr=new DataSourceTransactionManager(ds);
    	return dsTxMgr;
    }
}
