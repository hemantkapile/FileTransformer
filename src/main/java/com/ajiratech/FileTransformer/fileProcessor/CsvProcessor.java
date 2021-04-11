package com.ajiratech.FileTransformer.fileProcessor;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CsvProcessor {
	
	@Autowired
	private ProcessorFactory processorFactory;

	@Value("${inputFile}")
	private String inputFile;
	@Value("${outputFile}")
	private String outputFile;
	
	public void initiateProcessing() {
		
		File f = new File(inputFile);
		String sourceType = f.getName();
		System.out.println("sourceType = "+f.getName());
		ICsvProcessor processor = processorFactory.getProcessor(sourceType);
		
		String msg = processor.transform(inputFile,outputFile);
		System.out.println(msg);
	}

}
