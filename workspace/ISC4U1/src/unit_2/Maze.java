package unit_2;
import becker.robots.*;
import java.util.*;

public class Maze {
	static int[][] map = new int[10][10];
	public static void mark_pos(Robot_ robot, int count) {
		map[robot.getIntersection().getStreet()][robot.getIntersection().getAvenue()]=count;
	}
	public static void main(String[] args) {
		Random rand = new Random();
		MazeCity maze = new MazeCity(10,10);
		Robot_ robot = new Robot_(maze, 0,0,Direction.NORTH);
		Thing target = new Thing(maze, rand.nextInt(10), rand.nextInt(10));
		int count = 0;
		while(!robot.canPickThing()) {
//			mark_pos(robot);
//			while(!robot.frontIsClear())robot.turnLeft();
			count = 0;
			robot.turnLeft();
			if(robot.frontIsClear())robot.move();
			else {
				robot.turnRight();
				if(robot.frontIsClear())robot.move();
				
				else {
					robot.turnRight();
					if(robot.frontIsClear())robot.move();
					else {
						robot.turnRight();
						robot.move();
					}
				}
			}
	

//			
		}
		
		
	}

}
