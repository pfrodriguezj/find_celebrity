package com.celebrities.data;


public class RandomGeneratedCelebSource implements ICelebSource{

	private int populationSize = 0;
	
	public RandomGeneratedCelebSource(String populationSize) throws SourceException{
		try {
			this.populationSize = Integer.parseInt(populationSize);
		} catch(NumberFormatException e) {
			throw new SourceException("Exception formating population size parameter");
		}
	}
	
	@Override
	public int[][] readSource() throws SourceException {
		int famous = -1;
		famous = (int)(Math.random() * populationSize);

		if(populationSize <= 2 ) {
			throw new SourceException("Population size too low");
		}
		int[][] known= new int[populationSize][populationSize];
		int iKnowsJ = -1;
		
		for(int i = 0;i<populationSize;i++) {
			for(int j = 0; j<populationSize; j++) {
				if(i==j) {
					iKnowsJ = 1;
				} else if(i == famous) {
					iKnowsJ = 0;
				} else if(j == famous) {
					iKnowsJ = 1;
				} else {
					iKnowsJ = Math.random()>0.5?1:0;
				}
				known[i][j] = iKnowsJ;
			}
		}
		
		return known;
	}

	
}
