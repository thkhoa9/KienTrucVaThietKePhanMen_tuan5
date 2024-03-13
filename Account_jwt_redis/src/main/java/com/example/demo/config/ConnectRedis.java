package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class ConnectRedis {
     @Bean
     public LettuceConnectionFactory redisConnectionFactory() {
    	   return new LettuceConnectionFactory();
    	  
     }
     @Bean
     @Primary
     public RedisTemplate<Object,Object> redisTemplate(LettuceConnectionFactory redisConnectionFactory){
    	 RedisTemplate<Object,Object> template = new RedisTemplate<>();
    	template.setConnectionFactory(redisConnectionFactory);
    	return template;
     }
}