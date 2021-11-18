package unit_2;

import becker.robots.*;
/**
 * a special version of the becker RobotSE designed to clean a simulated stair case
 * @author Mike
 * 
 *@pre: the stairs are constructed as highlighted in our design document
 */
public class StefanSweeperRobot extends RobotSE{
	/**
	 * Constructor
	 * @param theCity city of the robot
	 * @param street starting street of the robot
	 * @param ave starting ave of the robot
	 * @param direction starting direction of the robot
	 */
	public StefanSweeperRobot(City theCity, int street, int ave, Direction direction) {
		super(theCity,street, ave,direction);
	}
	/**
	 * picks up an object only if its possible
	 * 
	 */
	private void safePickThing(){
		//is it possible to pick thing, if true pick thing
		if(this.canPickThing()) {
			this.pickThing();
		}
	}
	/**
	 * trys to pick thing on robots current position then moves up to the next step
	 * @pre robot is facing the stairs in the square directly to the right of a vertical wall
	 * @post robot is one space up and to the right of its previous position, facing east
	 */
	private void stepUp() {
		this.safePickThing();
		this.turnLeft();
		this.move();
		this.turnRight();
		this.move();
	}
	
	/**
	 * trys to pick up a thing and Robot takes a single step down and sets up for the next step
	 * @pre the robot is above an empty space(no wall) and facing south
	 * @post one square over and one down, facing south OR if the robot could not move to the next ave due to hitting the garbage, just one block down facing south
	 */
	private void stepDown() {
		this.move();
		this.safePickThing();
		this.turnLeft();
		if(this.frontIsClear())this.move();
		this.turnRight();
	}
	/**
	 * gets the robot from its starting position to the bottom of the stairs, picking up all possible things along the way
	 * @pre robot is facing east (the stairs)
	 * @post robot is one square to the right of the stairs facing east
	 */
	private void moveStair() {
		//has the robot reached the stairs
		while(this.frontIsClear()) {
			this.safePickThing();
			this.move();
		}
	}
	/**
	 * moves along the top platform of the stairs until it can move down, picking up all possible things along the way
	 * @pre the robot is on top of the stairs, facing east
	 * @post the robot is one ave past the top of the stairs, facing down
	 */
	
	private void findDown() {
		//try to find the stairs
		while(true) {
			this.safePickThing();
			this.turnRight();
			//is there no wall below the robot (found the end of the top of the stairs)
			if(this.frontIsClear()) {
				//stop looking
				break;
			}
			
			else {
				//continue moving
				this.turnLeft();
				this.safePickThing();
				this.move();
			}
		}

	}
	/**
	 * Climbs up the stairs
	 * @pre robot is facing east, against a wall
	 * @post robot is at the top of the stairs, facing east
	 */
	private void climbUp() {
		//step up until there is nolonger a stair infront
		while(!this.frontIsClear()) {
			this.stepUp();
		}
	}
	/**
	 * robot climbs down the stairs
	 * @pre robot is 1 ave past the end of the top of the stairs, facing down
	 * @post robot is at the bottom of the stairs, facing east
	 */
	private void climbDown() {
		//take a step down until there is floor below
		while(this.frontIsClear()) {
			this.stepDown();
		}
		//face ending direction
		this.turnLeft();
		
	}
	/**
	 * moves from the end of the stairs to the ave 1 to the left of the garbage, picking up all possible things along the way
	 * @pre robot is on the floor, on the other side of the stairs facing east
	 * @post robot is one block to the left of the garbage, facing it (east)
	 */
	private void findGarbage() {
		//move until the robot hits the garbage
		while(this.frontIsClear()) {
			this.safePickThing();
			this.move();
		}
	}
	/**
	 * Moves the robot from beside the garbage into it
	 * @pre robot is one ave to the left of the garbage, facing east
	 * @post robot is in the garbage facing south
	 */
	private void moveIntoGarbage() {
		this.safePickThing();
		this.turnLeft();
		this.move();
		this.turnRight();
		this.move();
		this.turnRight();
		this.move();
	}
	/**
	 * robot empties all things into the garbage
	 * @pre robot is in the garbage
	 * @post robot is in the garbage, with all things put down
	 */
	private void throwGarbage() {
		this.putAllThings();
	}
	
	/**
	 * robot leaves garbage and parks to the right of it
	 * @pre robot is in the garbage, facing south
	 * @post robot is one ave right of the garbage, facing east
	 */
	private void leaveGarbage() {
		this.turnAround();
		this.move();
		this.turnRight();
		this.move();
		this.turnRight();
		this.move(); 
		this.turnLeft();
	}
	
	/**
	 * robot moves beside the garbage, into it and puts all things
	 * @pre robot is one ave to the left of the garbage, facing east
	 * @post robot is one ave right of the garbage, facing east
	 */
	private void dumpGarbage() {
		this.moveIntoGarbage();
		this.throwGarbage();
		this.leaveGarbage();
	}
	/**
	 * cleans the stairs
	 * @pre robot is facing east and there are properly built stairs
	 * @post stairs are cleaned with the robot being 1 ave right of the garbage facing east
	 */
	public void sweepStairs() {
		this.moveStair();
		this.climbUp();
		this.findDown();
		this.climbDown();
		this.findGarbage();
		this.dumpGarbage();
	}
}
