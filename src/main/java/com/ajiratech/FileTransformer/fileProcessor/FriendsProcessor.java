package com.ajiratech.FileTransformer.fileProcessor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.opencsv.CSVWriter;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class FriendsProcessor implements ICsvProcessor{
	
	@Override
	public String transform(String inputFile,String outputFile) {
		
		List<String[]> newRows =  new ArrayList<>();
		try {
			List<String[]> rows =
			          Files.lines(Paths.get(inputFile))
			                .map(line -> line.split("\\|"))
			                .collect(Collectors.toList());
			String[] header = {"name","age"};
			newRows.add(header);
			
			for(int i =1;i<rows.size();i++) {
				String[] r = rows.get(i);
				if (Integer.parseInt(r[1]) <= 50) {
					newRows.add(r);
				}
			}
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
		} catch (Exception e) {
			e.printStackTrace();
			return "Something went Wrong";
			
		}
		
		
		
		
		return "Data Generated successfully. View the file at "+outputFile;
		
	}

}
