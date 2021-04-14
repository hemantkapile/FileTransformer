package com.ajiratech.FileTransformer.fileProcessor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


@Component
public class ColumnMergerProcessor  implements ICsvProcessor{
	
	@Override
	public List<String[]>  transform(String inputFile,int targetColumn1,String targetColumn2,String nameDelimiter) {
		
		List<String[]> newRows =  new ArrayList<>();
		try {
			List<String[]> rows =
			          Files.lines(Paths.get(inputFile))
			                .map(line -> line.split("\\|"))
			                .collect(Collectors.toList());
			String[] nd = nameDelimiter.split("&");
			int col2 = Integer.valueOf(targetColumn2)-1;
			for(int i =0;i<rows.size();i++) {
				String[] r = rows.get(i);
				 String[] arr = new String[r.length-1];
				 if(i!=0)
					 arr[targetColumn1]  = r[targetColumn1] + nd[1] +r[col2];
				 else
					 arr[targetColumn1]  = nd[0];
				 for(int j= col2;j<r.length;j++) {
					 if(j<r.length-1)
						arr[j]= r[j+1];
				 }
					newRows.add(arr);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return newRows;
		
	}

}
