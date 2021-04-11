package com.ajiratech.FileTransformer.fileProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessorFactory {
	
	@Autowired
	private FriendsProcessor friendsProcessor;
	@Autowired
	private EmployeesProcessor employeesProcessor;
	@Autowired
	private StudentProcessor studentProcessor;
	@Autowired
	private PeopleProcessor peopleProcessor;
	
	public ICsvProcessor getProcessor(String sourceType) {
		ICsvProcessor csvProcessor= null;
		switch (sourceType) {
		case "Friends.csv":
			csvProcessor = friendsProcessor;
			break;
		case "Employees.csv":
			csvProcessor = employeesProcessor;
			break;
		case "Students.csv":
			csvProcessor = studentProcessor;
			break;
		case "People.csv":
			csvProcessor = peopleProcessor;
			break;
		default:
			break;
		}
		return csvProcessor;
	}
	

}
