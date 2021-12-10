package u3;

import java.io.*;
import java.util.*;

public class SortingFaster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "C:\\Users\\Mike\\Documents\\school\\ICS4U1\\numbers.txt";
		ArrayList<Integer> unsorted= new ArrayList<Integer>();
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while(scanner.hasNext()) {
				unsorted.add((Integer)scanner.nextInt());
			}
		}
		catch(FileNotFoundException ex){
			System.out.print("here");
		}
		long start = System.currentTimeMillis();
		ArrayList<Integer> sorted = new ArrayList<Integer>();
//		System.out.println(sorted.size());
//		sorted.add(unsorted.get(0));
		boolean end = true;
		System.out.println(sorted.size());
		for(int i = 0; i < unsorted.size(); i++) {
			end = true;
			for(int j = 0; j < sorted.size(); j ++) {
				if(unsorted.get(i) <sorted.get(j)) {
					sorted.add(j, unsorted.get(i));
					end = false;
					break;
				}
			}
			if(end)sorted.add(i);
			
			
		}
		System.out.println(System.currentTimeMillis() - start);
	}

}
