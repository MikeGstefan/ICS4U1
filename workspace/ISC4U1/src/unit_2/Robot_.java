package unit_2;
import becker.robots.*;

/**
 * adds more functionality to Robot
 * @author mikeG
 *
 */
public class Robot_ extends Robot{
	/**
	 * constructor
	 * @param theCity city
	 * @param street starting street
	 * @param ave starting avenue
	 * @param direction starting direction
	 */
	public Robot_(City theCity, int street, int ave, Direction direction) {
		super(theCity,street, ave,direction);
	}
	
	
	/**
	 * turns the robot right
	 */
	public void turnRight() {
		this.turnLeft();
		this.turnLeft();
		this.turnLeft();
	}
	/**
	 * turns the robot around
	 */
	public void turnAround() {
		this.turnLeft();
		this.turnLeft();
	}
	/**
	 * moves for set distance
	 * @param steps distance to move
	 */
	public void move(int steps) {
		for(int i = 0; i < steps; i++)this.move();
	}
	/**
	 * picks up set number of things
	 * @param numThings how many to pickup
	 */
	public void pickThing(int numThings) {
		for(int i = 0; i<numThings; i++) {
			this.pickThing();
		}
	}
	/**
	 * counts all things on ccurrent position
	 * @return number of things
	 */
	public int countThings() {
		int count = 0;
		while(this.canPickThing()) {
			
			count++;
			this.pickThing();
		}
		for(int i = 0; i < count; i++)this.putThing();
		return count;
		
	}
	/**
	 * pick up all things on current position
	 */
	public void pickAllThings() {
		this.pickThing(this.countThings());
	}
	/**
	 * puts all things from backpack
	 */
	public void putAllThings() {
		for(int i = 0; i<=this.countThingsInBackpack()+2; i++)this.putThing();
	}
}
