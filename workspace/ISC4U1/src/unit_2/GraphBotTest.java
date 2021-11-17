package unit_2;

import becker.robots.*;
public class GraphBotTest {

	public static void main(String[] args) {
		City oakville = new City(10,10);
		GraphBot mark = new GraphBot(oakville,1,1,Direction.EAST);
		Thing[][] things = new Thing[4][4];
		for(int j = 0; j < 4; j++) {
			for(int i = 0; i <4; i++) {
				things[i][j] = new Thing(oakville, j+1,1);
			}
		}
		
		mark.drawGraph();
		
	}

}
