package unit_2;

import becker.robots.*;
import java.util.Random;
public class StefanStairTester {
	public static void main(String[] args) {
		
		int floorSt = 9, stairStart = 2, stairUpLen = 4, stairTopLen = 2, stairDownLen = 4, garbageDist = 3;
		City oakville = new City(10,15);
		StefanSweeperRobot sweep = new StefanSweeperRobot(oakville,floorSt,0,Direction.EAST); 
				
		Wall[] floor1 = new Wall[stairStart];
		for(int i = 0; i< stairStart; i++) {
			floor1[i] = new Wall(oakville, floorSt,i,Direction.SOUTH);
		}
		
		Wall[][] stairUp = new Wall[stairUpLen][2];
		for(int i = 0; i <stairUpLen; i++) {
			stairUp[i][1] = new Wall(oakville, i+floorSt-stairUpLen+1,stairStart+ stairUpLen-i-1,Direction.WEST);
			stairUp[i][0] = new Wall(oakville, i+floorSt-stairUpLen+1,stairStart+ stairUpLen-i-1,Direction.NORTH);
		}
		
		
		Wall[] stairTop = new Wall[stairTopLen];
		for(int i = 0; i<stairTopLen; i++) {
			stairTop[i]= new Wall(oakville, floorSt-stairUpLen+1,stairStart+ stairUpLen+i-1,Direction.NORTH);
		}
		
		
		Wall[][] stairDown = new Wall[stairDownLen][2];
		for(int i = 0; i <stairDownLen; i++) {
			stairDown[i][1] = new Wall(oakville, i+floorSt-stairUpLen+1,i+stairStart+stairUpLen+stairTopLen-2,Direction.EAST);
			stairDown[i][0] = new Wall(oakville, i+floorSt-stairUpLen+1,i+stairStart+stairUpLen+stairTopLen-2,Direction.NORTH);
		}
		
		Wall[] floor2 = new Wall[garbageDist];
		for(int i = 0; i < garbageDist; i++) {
			floor2[i] = new Wall(oakville, floorSt-stairUpLen+stairDownLen, i+stairStart+stairUpLen+stairTopLen+stairDownLen-2,Direction.SOUTH);
		}
		
		
		Wall[] garbage = new Wall[3];
		garbage[0] = new Wall(oakville,floorSt-stairUpLen+stairDownLen,stairStart+stairUpLen+stairTopLen+stairDownLen+garbageDist-2,Direction.WEST);
		garbage[1] = new Wall(oakville,floorSt-stairUpLen+stairDownLen,stairStart+stairUpLen+stairTopLen+stairDownLen+garbageDist-2,Direction.SOUTH);
		garbage[2] = new Wall(oakville,floorSt-stairUpLen+stairDownLen,stairStart+stairUpLen+stairTopLen+stairDownLen+garbageDist-2,Direction.EAST);
		
		Thing[] things = new Thing[stairStart+stairUpLen+stairTopLen+stairDownLen+garbageDist-2];
		Random rand = new Random();
		for(int i = 0; i <stairStart+stairUpLen+stairTopLen+stairDownLen+garbageDist-2; i++) {
//			if(rand.nextInt(2) == 1) {
				int y = floorSt;
				if (i <stairStart)y = floorSt;
				else if(i >stairStart-1 && i <stairStart+stairUpLen) y -= i-stairStart+1;
				else if(i <stairStart+stairUpLen+stairTopLen -1)y = floorSt-stairUpLen;
				else if(i < stairStart+stairUpLen+stairTopLen+stairDownLen-1)y = floorSt-stairUpLen+i-(stairStart+stairUpLen+stairTopLen)+2;
				else y = floorSt-stairUpLen+stairDownLen;
				things[i] = new Thing(oakville, y,i);
//			}
			
		}

		
		sweep.sweepStairs();
	}
}
