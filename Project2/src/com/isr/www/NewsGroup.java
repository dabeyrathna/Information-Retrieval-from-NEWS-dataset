package com.isr.www;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Normalize{
	
	Map<String, ArrayList<String>> newsGroupMap = new HashMap<String, ArrayList<String>>();
	Map<String,Integer> maxMap;

	public Normalize(String fileName) {
		readDataset(fileName);
		constructMaxFrequecyMap();
	}
	
	public void readDataset(String fileName){
		Scanner readDataFile = null;

		try{
			readDataFile = new Scanner(new File(fileName));

			while(readDataFile.hasNext()){	

				String[] line = readDataFile.nextLine().split("\\s",2);

				if(newsGroupMap.containsKey(line[0]))
					newsGroupMap.get(line[0]).add(line[1]);
				else{
					ArrayList<String> s = new ArrayList<String>();
					s.add(line[1]);
					newsGroupMap.put(line[0], s);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Check whether all the files are existing in current directory..");
			System.out.println("End...!!");
		}
		finally{
			readDataFile.close();
		}
	}
	
	public double getLogTwo(double num){
		return Math.log(num) / Math.log(2);
	}

	public void checkWordCountVariations(){
		int count = 0;
		int total = 0;
		int c = 0;
		for (Map.Entry<String,ArrayList<String>> entry : newsGroupMap.entrySet()) {
			for (String l : entry.getValue()) {
				count = l.split("\\s").length;	
				System.out.println("Count per line = "+count);
				total += count;
				count = 0;					
			}
			System.out.println("\nNews Group "+ ++c +" Total word count ==>  "+ total+"\n\n");
			total = 0;
		}
	}
	
	public void logTf(String keyWord){
		// display 20 newsgroup list according to rank + values
	}
	
	public void doubleLogTf(String keyWord){
		// display 20 newsgroup list according to rank + values
	}
	
	public void rowTf(String keyWord){
		// display 20 newsgroup list according to rank + values
	}
	
	public void constructMaxFrequecyMap(){
		maxMap = new HashMap<String, Integer>();
	}
}

public class NewsGroup {

	public static void main(String[] args) {

		Normalize normalize = new Normalize("newsGroup.txt"); 
		normalize.checkWordCountVariations();
	}

}
