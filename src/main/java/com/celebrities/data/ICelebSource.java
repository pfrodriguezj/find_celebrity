package com.celebrities.data;


public interface ICelebSource {

	public static final String COMMA_DELIMITER = ",";
	public int[][] readSource() throws SourceException;
}
