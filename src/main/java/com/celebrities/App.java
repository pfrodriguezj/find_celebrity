package com.celebrities;

import com.celebrities.data.CSVCelebSource;
import com.celebrities.data.DBCelebSource;
import com.celebrities.data.ICelebSource;
import com.celebrities.data.RandomGeneratedCelebSource;
import com.celebrities.data.SourceException;
import com.celebrities.util.CelebritiesUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String option = args[0];
    	String parameter = args[1];
		int [][]population = null;
		ICelebSource source = null;

		try {
			source = CelebritiesUtil.routeOption(option, parameter);
			population = source.readSource();
			
			if(population != null){
				CelebritiesUtil.printPopulation(population);
				System.out.println("Found famous: " +CelebrityFinder.findCelebrity(population));
			}
		} catch (SourceException e) {
			System.out.println(e);
		}
    }
}
