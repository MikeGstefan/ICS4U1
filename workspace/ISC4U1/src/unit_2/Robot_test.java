package unit_2;

import becker.robots.*;
import java.util.*;
/**
 * draws first letter with things
 * @author mikeG
 *
 */
public class Robot_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		City oakville = new City();
		Robot karel = new Robot(oakville,0,0,Direction.SOUTH);
		ArrayList<Thing> things = new ArrayList<Thing>();
		//create things
		for(int i = 0; i<19; i++) {
			things.add(new Thing(oakville, 0,0));
			karel.pickThing();
		}
		//move down left side
		karel.putThing();
		for(int i =0; i<6; i++) {
			karel.move();
			karel.putThing();
		}
		
		//back to top
		for(int j = 0; j<2; j++) {
			karel.turnLeft();
		}
		for(int i = 0; i <6; i++) {
			karel.move();
		}
		
		//setup for next part
		for(int j = 0; j<3; j++) {
			karel.turnLeft();
		}
		
		//go down diagnol
		for(int j = 0; j<3; j++) {
			karel.move();
			for(int i = 0; i<3; i++) {
				karel.turnLeft();
			}
			karel.move();
			karel.turnLeft();
			karel.putThing();
		}
		
		//back up
		for(int j = 0; j<3; j++) {
			karel.move();
			karel.turnLeft();
			karel.move();
			for(int i = 0; i<3; i++) {
				karel.turnLeft();
			}
			
			karel.putThing();
		}
		
		//down right side
		for(int i = 0; i<3; i++) {
			karel.turnLeft();
		}
		for(int i =0; i<6; i++) {
			karel.move();
			karel.putThing();
		}

		

		
		
	}

}
