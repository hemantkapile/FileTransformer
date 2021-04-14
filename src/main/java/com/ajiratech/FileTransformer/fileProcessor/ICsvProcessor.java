package com.ajiratech.FileTransformer.fileProcessor;

import java.util.List;

public interface ICsvProcessor {
	

public List<String[]> transform(String inputFile,int targetColumn,String feed1,String feed2);

}
