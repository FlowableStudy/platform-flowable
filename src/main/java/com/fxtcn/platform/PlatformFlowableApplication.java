package com.fxtcn.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

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

}

