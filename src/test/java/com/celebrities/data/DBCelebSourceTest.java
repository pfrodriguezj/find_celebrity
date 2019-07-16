package com.celebrities.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class DBCelebSourceTest {

	
	@Test
	public void testReadSource() {
		int[][] matrix;
		try {
			DBCelebSource dbCelebSource = new DBCelebSource("tabla");
			matrix = dbCelebSource.readSource();
			assertNotNull(matrix);
		} catch (SourceException e) {
			fail();
		} 
		
	}

}
