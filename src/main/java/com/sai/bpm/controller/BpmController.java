package com.sai.bpm.controller;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bpm")
public class BpmController {
	
	@PostMapping("/startProcess/{processKey}")
	public ResponseEntity<HttpStatus> startBpmProcess(@PathVariable String processKey,@RequestBody Map<String,Object> body){
		
		System.out.println("in contoller");
		ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
		
		RuntimeService runtimeService=processEngine.getRuntimeService();
		
		Map<String,Object> processVariables=body;
		
		ProcessInstance pi=runtimeService.startProcessInstanceByKey(processKey, processVariables);
		
		return ResponseEntity.ok(HttpStatus.OK);

	}

}
