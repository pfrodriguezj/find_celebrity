package com.celebrities;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CelebrityFinderTest {

	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAKnowsB() {
		int [][]matrix = {{0,0,1,0},
				  {1,0,1,0},
				  {0,0,1,0},
				  {0,1,1,0}};
		Assert.assertTrue(CelebrityFinder.aKnowsB(0, 2, matrix));
	}

	@Test
	public void testFindCelebrity() {
		int [][]matrix = {{0,0,1,0},
				  {1,0,1,0},
				  {0,0,1,0},
				  {0,1,1,0}};
		int celebrity = CelebrityFinder.findCelebrity(matrix);
		assertEquals(2, celebrity);
	}
	
	@Test
	public void testFindCelebrity3() {
		int [][]matrix = {{0,0,0,1},
				  {1,0,1,1},
				  {1,0,1,1},
				  {0,0,0,1}};
		int celebrity = CelebrityFinder.findCelebrity(matrix);
		assertEquals(3, celebrity);
	}

	@Test
	public void testNoCelebrity() {
		int [][]matrix = {{0,0,1,0},
				  		  {1,0,0,0},
				  		  {0,0,1,1},
				  		  {0,1,1,0}};
		int celebrity = CelebrityFinder.findCelebrity(matrix);
		assertEquals(-1, celebrity);
	}
	
	@Test
	public void testNobodyKnows() {
		int [][]matrix = {{0,0,0,0},
				  		  {0,0,0,0},
				  		  {0,0,0,0},
				  		  {0,0,0,0}};
		int celebrity = CelebrityFinder.findCelebrity(matrix);
		assertEquals(-1, celebrity);
	}

	@Test
	public void testIsEverybodyKnown() {
		int [][]matrix = {{1,1,1,1},
				  		  {1,1,1,1},
				  		  {1,1,1,1},
				  		  {1,1,1,1}};
		int celebrity = CelebrityFinder.findCelebrity(matrix);
		assertEquals(-1, celebrity);
	}

}
