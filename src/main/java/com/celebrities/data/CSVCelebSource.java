package com.celebrities.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.celebrities.util.CelebritiesUtil;

public class CSVCelebSource implements ICelebSource{

	private String sourcePath;
	
	public CSVCelebSource(String sourcePath) {
		this.sourcePath = sourcePath;
	}
	
	@Override
	/**
	 * Read a source csv of knokwns: for each position, 1 means true (x knows y), 
	 * 0 means false (x doesn't know y)
	 * @param sourcePath path to find data source, including file name
	 * @return knowns boolean matrix 
	 */
	public int[][] readSource() throws SourceException {
		List<List<Integer>> records = new ArrayList<>();
		File file = new File(sourcePath);
		try (InputStream inputStream = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){
			// skip the header of the csv
			records = br.lines().map(mapToItem).collect(Collectors.toList());
		} catch (IOException e) {
			throw new SourceException("Exception reading csv file " + e.getMessage());
		} 
		return CelebritiesUtil.listToMatrix(records);
	}

	private Function<String, List<Integer>> mapToItem = (line) -> {
		  String[] cells = line.split(COMMA_DELIMITER);// a CSV has comma separated lines
		  List<Integer> knows = new ArrayList<Integer>();
		  for(String c:cells) {
			  knows.add(c != null && c.equals("1")?1:0);
		  }
		  return knows;
	};
}