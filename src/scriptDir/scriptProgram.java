/**
 * Author: Ku Yi Sien
 * Script Program for SmartPeep Internship
 * IDE: Ecliplse IDE
 * Language: Java
 */
package scriptDir;

import java.util.*;
import java.util.Scanner;  
import java.io.*;  

public class scriptProgram {
	public static void main(String[] args) {
		
		Map <String, Integer> hm = new HashMap<String, Integer>();
		final File folder = new File(args[0]);
		try {
		listFilesForFolder(folder, hm);
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		/**
		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}	
		*/
		 Map<String, Integer> sortedMap = sortMap(hm);
	     printMap(sortedMap);
	}
	
	public static void listFilesForFolder(final File folder, Map <String, Integer> hm) throws FileNotFoundException {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry, hm);
	        } else {
	        	String fileName = fileEntry.getName().replace(".txt", "");
	        	Scanner fin = new Scanner(fileEntry);
	        	int i = fin.nextInt();
	        	hm.put(fileName, i);
	            fin.close();
	        }
	    }
	}
	public static Map<String, Integer> sortMap(Map <String, Integer> hm) {
		
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
	}
	
	public static void printMap(Map <String, Integer> map) {
		System.out.print("output: ");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
		    System.out.print(entry.getKey());
		}	
	}
	
}


