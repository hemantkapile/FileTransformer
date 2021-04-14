package com.ajiratech.FileTransformer.fileProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessorFactory {
	
	@Autowired
	private AgeFilterProcessor ageFilterProcessor;
	@Autowired
	private ColumnMergerProcessor columnMergerProcessor;
	@Autowired
	private DateFormatterProcessor dateFormatterProcessor;
	@Autowired
	private NewColumnProcessor newColumnProcessor;
	
	public ICsvProcessor getProcessor(String sourceType) {
		ICsvProcessor csvProcessor= null;
		switch (sourceType) {
		case "AGE_FILTER":
			csvProcessor = ageFilterProcessor;
			break;
		case "COLUMN_MERGER":
			csvProcessor = columnMergerProcessor;
			break;
		case "DATE_FORMATTER":
			csvProcessor = dateFormatterProcessor;
			break;
		case "NEW_COLUMN":
			csvProcessor = newColumnProcessor;
			break;
		default:
			break;
		}
		return csvProcessor;
	}
	

}
