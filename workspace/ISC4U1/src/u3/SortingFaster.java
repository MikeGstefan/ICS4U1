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
//		for(int i = 1; i < unsorted.size(); i++) {
//			if((unsorted.get(i) < unsorted.get(i-1))) {
//				for(int j = 0; j < i; j++) {
//					
//					if(unsorted.get(i) < unsorted.get(j)) {
//						unsorted.add(j, unsorted.get(i));
//						unsorted.remove(i+1);
//						break;
//					} 
//				}
//			}
//			
//		}
		for(int i = 1; i < unsorted.size(); i++) {
			if((unsorted.get(i) < unsorted.get(i-1))) {
				if(unsorted.get(i) < unsorted.get(i/2)) {
						for(int j = 0; j < i/2+1; j++) {
							if(unsorted.get(i) < unsorted.get(j)) {
								unsorted.add(j, unsorted.get(i));
								unsorted.remove(i+1);
								break;
							}
						}
				}
				else {
					for(int j = i/2; j < i; j++) {
						if(unsorted.get(i) < unsorted.get(j)) {
							unsorted.add(j, unsorted.get(i));
							unsorted.remove(i+1);
							break;
						}
					}
				}

			}
			
		}
		System.out.println(System.currentTimeMillis() - start);
		
		for( int i = 0; i < unsorted.size(); i++) {
			System.out.println(unsorted.get(i));
		}

	}

}
