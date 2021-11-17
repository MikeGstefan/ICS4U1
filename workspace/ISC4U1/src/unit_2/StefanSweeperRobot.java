package unit_2;

import becker.robots.*;
public class StefanSweeperRobot extends RobotSE{
	public StefanSweeperRobot(City theCity, int street, int ave, Direction direction) {
		super(theCity,street, ave,direction);
	}
	
	private void safePickThing(){
		if(this.canPickThing()) {
			this.pickThing();
		}
	}
	
	public void stepUp() {
		this.safePickThing();
		this.turnLeft();
		this.move();
		this.turnRight();
		this.move();
	}
	public boolean stepDown() {
		
		this.move();
		this.safePickThing();
		this.turnLeft();
		if(!this.frontIsClear())return true;
		this.move();
		this.turnRight();
		return false;
	}
	
	public void moveStair() {
		while(this.frontIsClear()) {
			this.safePickThing();
			this.move();
		}
	}
	
	public void findDown() {
		while(true) {
			this.safePickThing();
			this.turnRight();
			if(this.frontIsClear()) {
				break;
			}
			else {
				this.turnLeft();
				this.move();
			}
		}

	}
	
	public void climbUp() {
		while(!this.frontIsClear()) {
			this.stepUp();
		}
	}
	
	public void climbDown() {
		while(this.frontIsClear()) {
			if(this.stepDown()) {
				return;
			}
		}
		this.turnLeft();
		
	}
	
	public void findGarbage() {
		while(this.frontIsClear()) {
			this.safePickThing();
			this.move();
		}
	}
	
	public void moveToGarbage() {
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
	
	public void dumpGarbage() {
		this.moveToGarbage();
		this.throwGarbage();
	}
//	public void 
}
