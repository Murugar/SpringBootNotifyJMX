package com.iqmsoft.boot.jmx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;

import com.iqmsoft.boot.jmx.service.HelloMBeanImpl;

@EnableMBeanExport
@SpringBootApplication
public class AppSpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(AppSpringBoot.class, args);
    }
    
    @Bean
	public HelloMBeanImpl jmxResource() {
		return new HelloMBeanImpl();
	}
    
}
