package com.fxtcn.platform;

import org.flowable.ui.modeler.properties.FlowableModelerAppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
		exclude= {
			SecurityAutoConfiguration.class,
			SecurityAutoConfiguration.class,
			UserDetailsServiceAutoConfiguration.class,
			LiquibaseAutoConfiguration.class
			}
		)
public class PlatformFlowableApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatformFlowableApplication.class, args);
	}
	
	@Bean
	public FlowableModelerAppProperties flowableModelerAppProperties() {
		FlowableModelerAppProperties flowableModelerAppProperties=new FlowableModelerAppProperties();
		return flowableModelerAppProperties;
	}

}

