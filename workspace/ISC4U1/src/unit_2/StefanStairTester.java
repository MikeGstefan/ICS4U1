package unit_2;

import becker.robots.*;
import java.util.Random;
/**
 * Tests the stair sweeper robot
 * @author Mike
 *
 */
public class StefanStairTester {
	/**
	 * main testing function
	 * @param args
	 */
	public static void main(String[] args) {
		// vairables used to configure the stair construction  (these should be low enough that summed they will still fit on the screen)
		//bottom level of the stairs
		int floorSt = 7;
		//how far from the robots starting position the first stair should be
		int stairStart = 2;
		//how many steps up are wanted
		int stairUpLen = 2; 
		//how long is the top platform of the stairs
		int stairTopLen = 2;
		//how many steps down are wanted
		int stairDownLen = 4;
		//how far from the last step should the garbage be
		int garbageDist = 2;
		
		//set up objects
		City oakville = new City(10,15);
		StefanSweeperRobot sweep = new StefanSweeperRobot(oakville,floorSt,0,Direction.EAST); 
		
		
		//generate the floor from the robots starting position to the first step
		Wall[] floor1 = new Wall[stairStart];
		for(int i = 0; i< stairStart; i++) {
			floor1[i] = new Wall(oakville, floorSt,i,Direction.SOUTH);
		}
		
		
		//generate the stairs going up
		Wall[][] stairUp = new Wall[stairUpLen][2];
		for(int i = 0; i <stairUpLen; i++) {
			stairUp[i][1] = new Wall(oakville, i+floorSt-stairUpLen+1,stairStart+ stairUpLen-i-1,Direction.WEST);
			stairUp[i][0] = new Wall(oakville, i+floorSt-stairUpLen+1,stairStart+ stairUpLen-i-1,Direction.NORTH);
		}
		
		
		//generate the top level of the stairs
		Wall[] stairTop = new Wall[stairTopLen];
		for(int i = 0; i<stairTopLen; i++) {
			stairTop[i]= new Wall(oakville, floorSt-stairUpLen+1,stairStart+ stairUpLen+i-1,Direction.NORTH);
		}
		
		
		//generate the stairs going down
		Wall[][] stairDown = new Wall[stairDownLen][2];
		for(int i = 0; i <stairDownLen; i++) {
			stairDown[i][1] = new Wall(oakville, i+floorSt-stairUpLen+1,i+stairStart+stairUpLen+stairTopLen-2,Direction.EAST);
			stairDown[i][0] = new Wall(oakville, i+floorSt-stairUpLen+1,i+stairStart+stairUpLen+stairTopLen-2,Direction.NORTH);
		}
		
		//generate the floor conneting the bottom stair of the down section to the garbage
		Wall[] floor2 = new Wall[garbageDist+2];
		for(int i = 0; i < garbageDist+2; i++) {
			floor2[i] = new Wall(oakville, floorSt-stairUpLen+stairDownLen, i+stairStart+stairUpLen+stairTopLen+stairDownLen-2,Direction.SOUTH);
		}
		
		
		//generate the garbage can
		Wall[] garbage = new Wall[3];
		garbage[0] = new Wall(oakville,floorSt-stairUpLen+stairDownLen,stairStart+stairUpLen+stairTopLen+stairDownLen+garbageDist-2,Direction.WEST);
		garbage[1] = new Wall(oakville,floorSt-stairUpLen+stairDownLen,stairStart+stairUpLen+stairTopLen+stairDownLen+garbageDist-2,Direction.SOUTH);
		garbage[2] = new Wall(oakville,floorSt-stairUpLen+stairDownLen,stairStart+stairUpLen+stairTopLen+stairDownLen+garbageDist-2,Direction.EAST);
		
		
		//randomly generate the things on valid positions
		Thing[] things = new Thing[stairStart+stairUpLen+stairTopLen+stairDownLen+garbageDist-2];
		Random rand = new Random();
		for(int i = 0; i <stairStart+stairUpLen+stairTopLen+stairDownLen+garbageDist-2; i++) {
			// robot will have a 1/2 chance of spawning a thing for every valid position
			if(rand.nextInt(2) == 1) {
				//calulates the proper street for the thing given the avenue 
				int y = floorSt;
				if (i <stairStart) {
					//if ave is before the stairs
					y = floorSt;
				}
				else if(i >stairStart-1 && i <stairStart+stairUpLen) {
					//if ave is during the climb up
					y -= i-stairStart+1;
				}
				else if(i <stairStart+stairUpLen+stairTopLen -1) {
					//if ave is along the top of the stairs
					y = floorSt-stairUpLen;
				}
				else if(i < stairStart+stairUpLen+stairTopLen+stairDownLen-1) {
					//if ave is during the climb down
					y = floorSt-stairUpLen+i-(stairStart+stairUpLen+stairTopLen)+2;
				}
				else {
					//if ave is between the bottom of the stairs and the garbage
					y = floorSt-stairUpLen+stairDownLen;
				}
				
				//adds the thing
				things[i] = new Thing(oakville, y,i);
			}
			
		}

		//send robot to clean
		sweep.sweepStairs();
	}
}
