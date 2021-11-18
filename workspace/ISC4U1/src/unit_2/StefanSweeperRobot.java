package unit_2;

import becker.robots.*;
/**
 * a special version of the becker RobotSE designed to clean a simulated stair case
 * @author Mike
 * 
 *@pre: The robot is on the ground facing a set of stairs and a garbage can is after the
stairs. You can assume each step is always one by one and that the garbage can is a height and
width of one
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
	 * Robot takes a single step down and sets up for the next step
	 * @return if the step was not possible, only happens when the garbage is 1 square away from the bottom of the stairs
	 * @pre the robot is above an empty space(no wall) and facing south
	 * @post
	 */
	private boolean stepDown() {
		this.move();
		this.safePickThing();
		this.turnLeft();
		if(!this.frontIsClear())return true;
		this.move();
		this.turnRight();
		return false;
	}
	
	private void moveStair() {
		while(this.frontIsClear()) {
			this.safePickThing();
			this.move();
		}
	}
	
	private void findDown() {
		while(true) {
			this.safePickThing();
			this.turnRight();
			if(this.frontIsClear()) {
				break;
			}
			else {
				this.turnLeft();
				this.safePickThing();
				this.move();
			}
		}

	}
	
	private void climbUp() {
		while(!this.frontIsClear()) {
			this.stepUp();
		}
	}
	
	private void climbDown() {
		while(this.frontIsClear()) {
			if(this.stepDown()) {
				return;
			}
		}
		this.turnLeft();
		
	}
	
	private void findGarbage() {
		while(this.frontIsClear()) {
			this.safePickThing();
			this.move();
		}
	}
	
	private void moveToGarbage() {
		this.safePickThing();
		this.turnLeft();
		this.move();
		this.turnRight();
		this.move();
		this.turnRight();
		this.move();
	}
	
	private void throwGarbage() {
		this.putAllThings();
	}
	
	private void dumpGarbage() {
		this.moveToGarbage();
		this.throwGarbage();
	}
	
	public void sweepStairs() {
		this.moveStair();
		this.climbUp();
		this.findDown();
		this.climbDown();
		this.findGarbage();
		this.dumpGarbage();
	}
}
