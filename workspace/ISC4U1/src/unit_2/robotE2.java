package unit_2;
import java.util.ArrayList;

import becker.robots.*;


public class robotE2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		City oakville = new City();
		Robot karel = new Robot(oakville,0,0,Direction.SOUTH);
		
		Wall[][] walls = new Wall[5][4];
		ArrayList<Wall> wall = new ArrayList<Wall>();
		for(int i = 1; i <= 5; i++) {
			walls[i-1][0] = new Wall(oakville, 1,i,Direction.NORTH);
		}
		for(int i = 1; i <= 4; i++) {
			walls[i-1][1] = new Wall(oakville, i, 5,Direction.EAST);
		}
		for(int i = 1; i <= 5; i++) {
			walls[i-1][2] = new Wall(oakville, 4,i,Direction.SOUTH);
		}
		for(int i = 1; i <= 4; i++) {
			walls[i-1][3] = new Wall(oakville, i, 1,Direction.WEST);
		}

		
	}

}
