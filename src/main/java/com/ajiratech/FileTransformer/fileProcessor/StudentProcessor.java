package com.ajiratech.FileTransformer.fileProcessor;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.opencsv.CSVWriter;

@Component
public class StudentProcessor  implements ICsvProcessor{
	
	@Override
	public String transform(String inputFile,String outputFile) {
		
		List<String[]> newRows =  new ArrayList<>();
		try {
			List<String[]> rows =
			          Files.lines(Paths.get(inputFile))
			                .map(line -> line.split("\\|"))
			                .collect(Collectors.toList());
			String[] header = {"name","dob"};
			newRows.add(header);
			
			for(int i =1;i<rows.size();i++) {
				String[] r = rows.get(i);
				 String[] arr = new String[2];
				 arr[0]  = r[0];
			     Date date = new SimpleDateFormat("yyyy-MM-dd").parse(r[1]);  
			     DateFormat dateFormat = new SimpleDateFormat("MMM d, YYYY");  
				 String strDate = dateFormat.format(date);
				 arr[1]  = strDate;
				 newRows.add(arr);
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