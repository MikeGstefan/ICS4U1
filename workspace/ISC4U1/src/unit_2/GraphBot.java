package unit_2;

import becker.robots.*;
public class GraphBot extends RobotSE{
	public GraphBot(City theCity, int street, int ave, Direction direction) {
		super(theCity,street, ave,direction);
	}
	private void collectObjs() {
		this.pickAllThings();
	}
	private int moveOut() {
		this.move(2);
		int dist =this.countThingsInBackpack();
		for(int i = 0; i < dist; i++) {
			this.putThing();
			this.move();
		}
		return dist+2;
	}
	
	private void returnStart(int dist) {
		this.turnAround();
		this.move(dist);
	}
	
	private void drawLine() {
		this.collectObjs();
		this.returnStart(moveOut());
	}
	
	private void moveDown() {
		this.turnLeft();
		this.move();
		this.turnLeft();
	}
	
	public void drawGraph() {
		while(this.canPickThing()) {
			this.drawLine();
			this.moveDown();
		}
	}

}
