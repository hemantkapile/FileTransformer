package com.ajiratech.FileTransformer.Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ajiratech.FileTransformer.fileProcessor.CsvProcessor;
import org.springframework.boot.Banner;
import static java.lang.System.exit;

@SpringBootApplication
@ComponentScan({"com.ajiratech.FileTransformer"})
public class FileTransformerApplication implements CommandLineRunner {
	
	@Autowired
	private CsvProcessor csvProcessor;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(FileTransformerApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		csvProcessor.initiateProcessing();
       

        exit(0);
	}

}
