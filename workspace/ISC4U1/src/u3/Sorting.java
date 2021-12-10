package u3;
import java.util.*;
import java.io.*;
public class Sorting {

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
		int min = 100000000, count = 0, lastMin = -1;
		for(int i = 0; i < unsorted.size(); i++){
			
			min = 100000000;
			for(int j = 0; j < unsorted.size(); j++){
				if(unsorted.get(j) < min && unsorted.get(j) >lastMin) {
					min = unsorted.get(j);
					count = 1;
				}
				else if(unsorted.get(j) == min) {
					count ++;
				}
			}
			for(int j = 0; j < count; j++) {
				sorted.add(min);
			}
			lastMin = min;
			count = 0;
		}
		System.out.println(System.currentTimeMillis() - start);
	}
	

}
