package unit_2;
import java.util.*;

import becker.robots.*;


public class robote3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		City oakville = new City();
		Robot karel = new Robot(oakville,1,1,Direction.EAST);
		
		Wall[][] walls = new Wall[5][4];
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
		Thing[] things = new Thing[5];
		Random rand = new Random();
		for(int i = 0; i<5; i++) {
			things[i] = new Thing(oakville, rand.nextInt(4)+1, rand.nextInt(5)+1);
		}
		
			for(int j = 0; j <4; j++) {
				while(karel.canPickThing())karel.pickThing();
				karel.move();
			}
			for(int j = 0; j <3; j++) {
				karel.turnLeft();
			}
			
			while(karel.canPickThing())karel.pickThing();
			karel.move();
			for(int j = 0; j <3; j++) {
				karel.turnLeft();
			}
			for(int j = 0; j <4; j++) {
				while(karel.canPickThing())karel.pickThing();
				karel.move();
			}
			karel.turnLeft();
			for(int j = 0; j <1; j++) {
				while(karel.canPickThing())karel.pickThing();
				karel.move();
			}
			karel.turnLeft();
			for(int j = 0; j <4; j++) {
				while(karel.canPickThing())karel.pickThing();
				karel.move();
			}
			for(int j = 0; j <3; j++) {
				karel.turnLeft();
			}
			
			while(karel.canPickThing())karel.pickThing();
			karel.move();
			for(int j = 0; j <3; j++) {
				karel.turnLeft();
			}
			for(int j = 0; j <4; j++) {
				while(karel.canPickThing())karel.pickThing();
				karel.move();
			}
			for(int j = 0; j <3; j++) {
				karel.turnLeft();
			}
			for(int j = 0; j <3; j++) {
				while(karel.canPickThing())karel.pickThing();
				karel.move();
			}
			
			for(int j = 0; j <5; j++) {
				karel.putThing();
			}
			
			

	}

}
