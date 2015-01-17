package com.springboot.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class DBConfig
{
	@Bean
	public MongoFactoryBean mongo()
	{
		MongoFactoryBean mongo = new MongoFactoryBean();
		mongo.setHost("127.0.0.1");
		mongo.setPort(27017);
		return mongo;
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception
	{
		return new MongoTemplate(mongo().getObject(), "TEST_DB");
	}
}