package com.celebrities;

import java.util.Stack;

public class CelebrityFinder {

	public static boolean aKnowsB(int a, int b, int matrix[][]){
		return matrix[a][b] == 1;
	}
	
	public static Integer findCelebrity(int matrix[][]){
		Stack<Integer> celebrities = new Stack<Integer>();
		
		for(int i=0;i<matrix.length;i++){
			celebrities.add(i);
		}
		
		while (celebrities.size()> 1) {
			Integer personA = celebrities.pop();
			Integer personB = celebrities.pop();
			//pA doesn't know pB, pB is not celebrity, remove pB from set and break;
			//pA knows pB, pA isn't celebrity, remove pA from set and continue;
			if(!aKnowsB(personA, (Integer)personB, matrix) && aKnowsB(personB, (Integer)personA, matrix)) {
				celebrities.add(personA);
			} 
			if (!aKnowsB(personB, (Integer)personA, matrix) && aKnowsB(personA, (Integer)personB, matrix)) {
				celebrities.add(personB);
			}
			
		}
		
		//it must remain just 1 person on celebrities set
		//validate if it is really a celebrity
		int person = celebrities.stream().findFirst().orElse(-1);
		if( person != -1) {
			for(int i = 0;i<matrix.length;i++) {
				if(i != person && matrix[i][person] != 1 && matrix[person][i] != 0 ) {
					person = -1;
					break;
				}
			}
		}
		return person;
	}
}
