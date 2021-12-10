package unit_2;

import becker.robots.*;
/** 
 * A special version of the becker robotSE which is designed to collect amazon packages
 * @version 2/12/21
 * @author Mike Stefan 
*/
public class StefanMoverRobot extends RobotSE{
    private int traction;
    private boolean done = false;

    /**
     * constructor for the robot object
     * 
     * @param traction the amount of moves the robot can make befor sliping while carrying packages 
     * @param theCity city of the robot
	 * @param street starting street of the robot
	 * @param ave starting ave of the robot
	 * @param direction starting direction of the robot
    */
    StefanMoverRobot(int traction, City theCity, int street, int ave, Direction direction) {
        super(theCity,street, ave,direction);
        this.traction = traction;
    }

    /** 
     * moves to the pile of packages 
     * @pre the robot is in the right row and facing the packages
     * @pre there is atleast one package in the pile
     * @post the robot is ontop of the pile of objects
    */
    private void moveTo(){ 
        while(!this.canPickThing()){ 
            this.move();
        }
    }

    /**
     * collects the clear
     * @pre robot is ontop of the packages and there is atleast one
     * @post robot is holding 1 package, is facing back towards home and sets done flag to true if there are no more to pickup
     */
    private void collectPackages(){ 
        this.pickThing();
        if(!this.canPickThing()){
            done = true;
        }
        this.turnAround();
    }

    /**
     * moves the robot back into the house, handling slippaged due to traction
     * @pre the robot is facing home
     * @post the robot is in home
     */
    private void moveBack(){ 
        int distmoved = 0;
        //move while not in the house
        while(this.frontIsClear()){ 
            //has the robot moved far enough to slip
            if(distmoved != 0 && distmoved % this.traction ==0){
                this.turnLeft(4);
            }
            this.move();
            distmoved++;
        }
    }

    /**
     * moves robot from in the house back to its starting position
     * @pre robot is in the house
     * @post robot is back at the starting position
     */
    private void returnToStart(){
        this.turnAround();
        this.move();
    }

    /**
     * robot will collect all the packages, return them to the house and end at starting pos
     * @pre robot is started facing the packages, 1 square infront of the open side of the house
     * @post all packages are in the house robot is back to origin
     */
    public void clearPackages(){ 
        while(!done){ 
            this.moveTo();
            this.collectPackages();
            this.moveBack();
            this.putThing();
            this.returnToStart();
        }
    }
}