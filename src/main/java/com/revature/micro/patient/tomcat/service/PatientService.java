package com.revature.micro.patient.tomcat.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.micro.patient.tomcat.mongo.Patient;
import com.revature.micro.patient.tomcat.mongo.PatientRepository;

@Service
public class PatientService {

	private PatientRepository repository;
	private static Log logger = LogFactory.getLog(PatientService.class);
	
	@Autowired
	public void setRepository(PatientRepository repository) {
		this.repository = repository;
	}
	
	public void save(Patient patient){
		logger.info("Saving patient: " + patient);
		repository.save(patient);
	}
	
	public List<Patient> findAll(){
		return repository.findAll();
	}
	
}
