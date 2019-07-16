package com.celebrities.util;

import java.util.Arrays;
import java.util.List;

import com.celebrities.data.CSVCelebSource;
import com.celebrities.data.DBCelebSource;
import com.celebrities.data.ICelebSource;
import com.celebrities.data.RandomGeneratedCelebSource;
import com.celebrities.data.SourceException;

public class CelebritiesUtil {

	public static final String CSV_OPTION = "CSV";
	public static final String DB_OPTION = "DB";
	public static final String RAND_OPTION = "RAND";
	
	/**
	 * Converts a List of Lists into a int matrix (for standardization)
	 * @param population
	 * @return
	 */
	public static int[][] listToMatrix(List<List<Integer>> population){
		int[][] populationMatrix = new int[population.size()][population.size()];
		
		for(int i = 0;i<population.size();i++) {
			populationMatrix[i] = population.get(i).stream().mapToInt(n->n).toArray();
		}
		return populationMatrix;
	}
	
	public static ICelebSource routeOption(String option, String parameter) throws SourceException{
		ICelebSource selectedSource = null;
		option = option.toUpperCase();
		if (CSV_OPTION.equals(option)){
			selectedSource = new CSVCelebSource(parameter);
		}
		if (DB_OPTION.equals(option)) {
			selectedSource = new DBCelebSource(parameter);
		}
		if (RAND_OPTION.equals(option)) {
			selectedSource = new RandomGeneratedCelebSource(parameter);
		}
		return selectedSource;
	}
	
	public static void printPopulation(int [][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

}
