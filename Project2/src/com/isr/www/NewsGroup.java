package com.isr.www;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class NewsGroup {

	public static void main(String[] args) {
		Map<String, ArrayList<String>> newsGroupMap = new HashMap<String, ArrayList<String>>();
		Scanner readDataFile = null;
		
		try{
			readDataFile = new Scanner(new File("qq.txt"));
			
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
			

			int count = 0;
			int total = 0;
			int c = 0;
			for (Map.Entry<String,ArrayList<String>> entry : newsGroupMap.entrySet()) {    //  counting words in dataset
				for (String l : entry.getValue()) {
					count = l.split("\\s").length;	
					System.out.println("Count per line = "+count);
					total += count;
					count = 0;
						
				}
				System.out.println("\nNews Group "+ ++c +" Total word count ===>  "+ total+"\n\n");
				total = 0;
			}
		}

		catch (FileNotFoundException e) {
			System.out.println("Check whether all the files are existing in current directory...");
			System.out.println("End...!!");
		}
		finally{
			readDataFile.close();
		}

	}

}
