package com.fxtcn.platform;

import org.flowable.ui.modeler.properties.FlowableModelerAppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(
//		exclude= {
//			SecurityAutoConfiguration.class,
//			SecurityAutoConfiguration.class,
//			UserDetailsServiceAutoConfiguration.class,
//			LiquibaseAutoConfiguration.class
//			}
		)
@ComponentScan(basePackages = {"com.fxtcn.platform","org.flowable.ui"})
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

