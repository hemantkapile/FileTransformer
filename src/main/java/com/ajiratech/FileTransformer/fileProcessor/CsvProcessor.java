package com.ajiratech.FileTransformer.fileProcessor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.opencsv.CSVWriter;

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
	@Value("${configFile}")
	private String configFile;

	public void initiateProcessing() {

		String module = "";
		try {
			List<String[]> rows = Files.lines(Paths.get(configFile)).map(line -> line.split("\\|")).collect(Collectors.toList());

				String[] configs = rows.get(1);
				module = configs[0];
			if (StringUtils.isNotBlank(module)) {
			System.out.println("module = " + module);
			ICsvProcessor processor = processorFactory.getProcessor(module);
			int targetColumn = Integer.valueOf(configs[1]);
			String inputDateFormat = configs[2];
			String outputDateFormat = configs[3];
			List<String[]> newRows = processor.transform(inputFile,targetColumn-1,inputDateFormat,outputDateFormat);

			
			File file = new File(outputFile);
			 file = file.getParentFile();	
			 if(!file.exists()){
				file.mkdir();
				System.out.println("New output dir created at "+file.getAbsolutePath());
			 }
		
			CSVWriter writer = new CSVWriter(new FileWriter(outputFile),'|',CSVWriter.NO_QUOTE_CHARACTER,
                   CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                   CSVWriter.DEFAULT_LINE_END);
			writer.writeAll(newRows);
			writer.close();
			System.out.println("Data Generated successfully. View the file at "+outputFile);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Something went Wrong");
			e.printStackTrace();
		}

	}

}
