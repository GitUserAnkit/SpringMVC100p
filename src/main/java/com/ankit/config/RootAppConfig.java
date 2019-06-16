package com.ankit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value= {ServiceConfig.class,PersistenceConfig.class,AopConfig.class})
public class RootAppConfig {

}
