/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.revature.micro.patient.tomcat.web;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.micro.patient.tomcat.mongo.Patient;
import com.revature.micro.patient.tomcat.service.PatientService;

@RestController
public class SampleController {

	private PatientService service;
	
	@Autowired
	public void setService(PatientService service) {
		this.service = service;
	}

	@RequestMapping("/")
	public String helloWorld() {
		return "Spring Boot REST API using Dockers and MongoDB";
	}
	
	@RequestMapping(value="patient", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Patient patient){
		LoggerFactory.getLogger(SampleController.class).info("Saving patient: " + patient);
		service.save(patient);
	}
	
	@RequestMapping(value="patient", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Patient> findAll(){
		return service.findAll();
	}
}
