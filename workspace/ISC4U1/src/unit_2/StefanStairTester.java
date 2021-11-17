package unit_2;

import becker.robots.*;

public class StefanStairTester {
	public static void main(String[] args) {
		City oakville = new City(10,15);
		StefanSweeperRobot sweep = new StefanSweeperRobot(oakville,4,0,Direction.EAST); 
		Wall[] floor = new Wall[15];
		for(int i = 0; i< 15; i++) {
			floor[i] = new Wall(oakville, 4,i,Direction.SOUTH);
		}
		Wall[][] stairUp = new Wall[3][2];
		for(int i = 0; i <3; i++) {
			stairUp[i][1] = new Wall(oakville, i+2,4-i,Direction.WEST);
			stairUp[i][0] = new Wall(oakville, i+2,4-i,Direction.NORTH);
		}
		Wall[][] stairDown = new Wall[3][2];
		for(int i = 0; i <3; i++) {
			stairDown[i][1] = new Wall(oakville, i+2,5+i,Direction.EAST);
			stairDown[i][0] = new Wall(oakville, i+2,5+i,Direction.NORTH);
		}
		Wall[] garbage = new Wall[3];
		garbage[0] = new Wall(oakville,4,9,Direction.WEST);
		garbage[1] = new Wall(oakville,4,9,Direction.SOUTH);
		garbage[2] = new Wall(oakville,4,9,Direction.EAST);
		
		Thing[] things = new Thing[10];
		things[0] = new Thing(oakville, 4,0);
		things[1] = new Thing(oakville, 4,1);
		things[2] = new Thing(oakville, 3,2);
		things[3] = new Thing(oakville, 2,3);
		things[4] = new Thing(oakville, 1,4);
		things[5] = new Thing(oakville, 1,5);
		things[6] = new Thing(oakville, 2,6);
		things[7] = new Thing(oakville, 3,7);
		things[8] = new Thing(oakville, 4,8);
		things[9] = new Thing(oakville, 4,9);
		
		sweep.moveStair();
		sweep.climbUp();
		sweep.findDown();
		sweep.climbDown();
		sweep.findGarbage();
		sweep.dumpGarbage();
	}
}
