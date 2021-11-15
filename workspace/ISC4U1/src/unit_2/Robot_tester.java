package unit_2;
import becker.robots.*;
public class Robot_tester {

	public static void main(String[] args) {
		City oakville = new City();
		Robot_ karel = new Robot_(oakville,0,0,Direction.SOUTH);
		karel.turnRight();
		karel.turnAround();
		karel.move(3);
		Thing[] things = new Thing[4];
		for(int i = 0; i <4; i++) {
			things[i] = new Thing(oakville, 0,3);
		}
		karel.pickThing(4);
		System.out.println(karel.countThingsInBackpack());
		karel.putAllThings();
		System.out.println(karel.countThingsInBackpack());
		System.out.println(karel.countThings());
		karel.pickAllThings();
		karel.putAllThings();
	}

}
