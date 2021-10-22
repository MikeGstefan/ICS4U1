package unit_2;

import becker.robots.*;
public class Robot_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		City oakville = new City();
		Robot karel = new Robot(oakville,0,0,Direction.EAST);
		for(int i = 0; i < 2; i++)karel.move();
		
	}

}
