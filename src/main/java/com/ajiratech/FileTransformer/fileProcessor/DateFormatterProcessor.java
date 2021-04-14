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
public class DateFormatterProcessor  implements ICsvProcessor{
	
	@Override
	public List<String[]> transform(String inputFile,int targetColumn,String inputDateFormat,String outputDateFormat) {
		
		List<String[]> newRows =  new ArrayList<>();
		try {
			List<String[]> rows =
			          Files.lines(Paths.get(inputFile))
			                .map(line -> line.split("\\|"))
			                .collect(Collectors.toList());
			newRows.add(rows.get(0));
			
			for(int i =1;i<rows.size();i++) {
				String[] r = rows.get(i);
				 String[] arr = new String[r.length];
				 arr[0]  = r[0];
			     Date date = new SimpleDateFormat(inputDateFormat).parse(r[targetColumn]);  
			     DateFormat dateFormat = new SimpleDateFormat(outputDateFormat);  
				 String strDate = dateFormat.format(date);
				 arr[1]  = strDate;
				 newRows.add(arr);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return newRows;
		
	}
}
