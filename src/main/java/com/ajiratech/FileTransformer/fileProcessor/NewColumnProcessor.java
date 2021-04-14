package com.ajiratech.FileTransformer.fileProcessor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;


@Component
public class NewColumnProcessor implements ICsvProcessor {

	@Override
	public List<String[]> transform(String inputFile, int targetColumn, String agepassFailValue, String newColumnName) {

		List<String[]> newRows = new ArrayList<>();
		try {
			List<String[]> rows = Files.lines(Paths.get(inputFile)).map(line -> line.split("\\|"))
					.collect(Collectors.toList());

			String[] condition = agepassFailValue.split(",");
			for (int i = 0; i < rows.size(); i++) {
				String[] r = rows.get(i);
				String[] arr = new String[r.length + 1];
				for (int j = 0; j < r.length + 1; j++) {
					if (j < r.length) {
						arr[j] = r[j];
					} else {
						if (i == 0) {
							arr[j] = newColumnName;
						} else {
							if (Integer.parseInt(r[1]) > Integer.parseInt(condition[0])) {
								arr[j] = condition[1];
							} else {
								arr[j] = condition[2];
							}
						}

					}
				}
				newRows.add(arr);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return newRows;

	}
}
