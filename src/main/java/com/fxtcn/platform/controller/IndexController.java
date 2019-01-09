package com.fxtcn.platform.controller;

import org.flowable.engine.DynamicBpmnService;
import org.flowable.engine.FormService;
import org.flowable.engine.HistoryService;
import org.flowable.engine.IdentityService;
import org.flowable.engine.ManagementService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private IdentityService identityService;;
	@Autowired
	private TaskService taskService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private DynamicBpmnService dynamicBpmnService;
	@Autowired
	private FormService formService;
	@Autowired
	private ManagementService managementService;
	@Autowired
	private ProcessEngineConfiguration processEngineConfiguration;

	@GetMapping("/login")
	public Object getService() {

		System.out.println("流程引擎类：" + processEngine);

		taskService = processEngine.getTaskService();
		runtimeService = processEngine.getRuntimeService();
		repositoryService = processEngine.getRepositoryService();
		historyService = processEngine.getHistoryService();
		dynamicBpmnService = processEngine.getDynamicBpmnService();
		formService = processEngine.getFormService();
		identityService = processEngine.getIdentityService();
		managementService = processEngine.getManagementService();
		processEngineConfiguration = processEngine.getProcessEngineConfiguration();

		String name = processEngine.getName();

		System.out.println("流程引擎的名称： " + name);
		System.out.println(processEngineConfiguration);
		return "success";
	}
}
