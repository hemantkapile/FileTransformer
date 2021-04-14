package com.ajiratech.FileTransformer.fileProcessor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class AgeFilterProcessor implements ICsvProcessor{
	
	@Override
	public List<String[]> transform(String inputFile,int targetColumn,String filterAge, String feed2) {
		
		List<String[]> newRows =  new ArrayList<>();
		try {
			List<String[]> rows =
			          Files.lines(Paths.get(inputFile))
			                .map(line -> line.split("\\|"))
			                .collect(Collectors.toList());
			
			newRows.add(rows.get(0));
			int age = Integer.valueOf(filterAge);
			for(int i =1;i<rows.size();i++) {
				String[] r = rows.get(i);
				if (Integer.parseInt(r[targetColumn]) <= age) {
					newRows.add(r);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return newRows;
		
	}

}
