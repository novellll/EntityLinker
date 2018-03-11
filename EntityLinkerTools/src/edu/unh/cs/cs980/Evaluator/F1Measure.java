package edu.unh.cs.cs980.Evaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class F1Measure {

	public List<Double> evaluateMeasure(Map<String, List<String>> groundTruth, Map<String, List<String>> dBpediaentries) {
		// TODO Auto-generated method stub
		double f1Score = 0.0;
		List<Double> F1ScoreList = new ArrayList<Double>();
		for (Entry<String, List<String>> iter : groundTruth.entrySet()) {
			List<String> trueEntities = new ArrayList<String>();
			List<String> retrievedEntities = new ArrayList<String>();

			
			// Get the values of truth and retrieved to commpare the reuslt
			trueEntities = iter.getValue();
			retrievedEntities = dBpediaentries.get(iter.getKey());
			int noOfCorrectEntities = 0;

			for (int i = 0; i < retrievedEntities.size(); i++) {
				if (trueEntities.contains(retrievedEntities.get(i)))
				{
					System.out.println("cntains");
					noOfCorrectEntities++;
				}
				
				System.out.println(noOfCorrectEntities);

			}
			
			
			
			if( (trueEntities.size() == 0) && (retrievedEntities.size() == 0))
			{
				f1Score = 1.0;
			}
			
			else if ((trueEntities.size() == 0) && (retrievedEntities.size() != 0)) {
				f1Score = 0.0;
			}
			
			else if ((trueEntities.size() != 0) && (retrievedEntities.size() == 0)) {
				f1Score = 0.0;
			}
			
			else
			{
				double r = noOfCorrectEntities / trueEntities.size();
				double p = noOfCorrectEntities / retrievedEntities.size();
				
				if((r == 0) && (p == 0))
				{
					f1Score = 0.0;
				}
				else
				{
					f1Score = ( 2 * p * r) / (r + p) ;
				}
			}
			F1ScoreList.add(f1Score);
			

		}

		return F1ScoreList;
	}

}
