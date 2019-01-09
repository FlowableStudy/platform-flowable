package com.fxtcn.platform.controller;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.DeploymentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/process")

public class ProcessController{
	@Autowired
	RepositoryService repositoryService;

	@RequestMapping(value = "/deploy")
	@ResponseBody
	public Object deploy(){
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment()
				.category("dataobject")
				.key("dataobject")
				.name("dataobject")
				.addClasspathResource("dataobject.bpmn20.xml");
		Deployment deploy = deploymentBuilder.deploy();

		System.out.println("请假流程部署,流程ID: " + deploy.getId());

		return deploy;
	}

}
