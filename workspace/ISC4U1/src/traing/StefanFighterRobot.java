package traing;
import becker.robots.*;
import java.util.*;
import java.awt.Color;

/** 
 * My version of the FighterRobot ai for use in the genectic algorithm
 * @version 01/20/2022
 * @author Mike Stefan
*/
public class StefanFighterRobot extends FighterRobot{

    private int health = 100;
    private int energy;
    private int turnCount = 0;
    private boolean attacking = false;
    private StefanOppData[] data = new StefanOppData[BattleManager.NUM_PLAYERS];

    //scaler values, used for desion matrix
    private double MOVE_DIST_SCALER = 0.0;
    private double OPP_DIST_SCALER = 0.0;
    private double DIFF_SCALER = 0.0;
    private double DIFF_ACCUARACY_SCALER = 0.0;
    private double HEALTH_WEIGHT = 0.0;
//best of: 93| 5, 3, 2, 0.196188, 0.600000, 5.990721, 17.954302
//

    /**
     * Contructor
     * @param c city
     * @param a avenue
     * @param s street
     * @param d Direction
     * @param id robot id
     * @param health starting health
     * @param params the GenData object used for genetic trainging
     */
	public StefanFighterRobot (City c, int a, int s, Direction d, int id, int health, GenData params){
		super(c,a,s,d,id,params.attack,params.defence,params.numMoves);
        //pull data from GenData into local copies to allow for easier conversion from training version to final
        this.MOVE_DIST_SCALER = params.MOVE_DIST_SCALER;
        this.OPP_DIST_SCALER = params.OPP_DIST_SCALER;
        this.DIFF_SCALER = params.DIFF_SCALER;
        this.DIFF_ACCUARACY_SCALER = params.DIFF_ACCUARACY_SCALER;
        this.HEALTH_WEIGHT = params.HEALTH_WEIGHT;
        this.health = health;
        for(int i = 0; i < BattleManager.NUM_PLAYERS; i++){ 
            this.data[i] = new StefanOppData(i, 0, 0, 0, this);
        }
        this.setLabel();
	}


    /** 
     * set label overload which displays health and sets colour to black when dead
    */
    public void setLabel()
	{
		this.setLabel("" + this.health);
        if(this.health == 0){
            this.setColor(Color.BLACK);
        }
        else{
            this.setColor(Color.RED);
        }
        
	}

    /**
     * Fighter robot definition of goToLocation
     * Moves the robot to the passed location
     * @param a avenue
     * @param s street
     */
    public void goToLocation(int a, int s){ 
        //is the target to the east
        if(a > this.getAvenue()){
            //turn to face east
          while(this.getDirection() != Direction.EAST){ 
              this.turnLeft();
          }
        }
        else{ 
            //turn to face west
            while(this.getDirection() != Direction.WEST){ 
                this.turnLeft();
            }
        }
        //move that number of avenues
        this.move(Math.abs(this.getAvenue() -a));


        //is the target to the north?
        if(this.getStreet() > s){ 
            //turn to face north
            while(this.getDirection() != Direction.NORTH){ 
                this.turnLeft();
            }
        }
        else{
            //turn to face south
            while(this.getDirection() != Direction.SOUTH){ 
                this.turnLeft();
            }
        }
        //move that number of streets
        this.move(Math.abs(this.getStreet() -s));
    }



    /**
     * My definition of the takeTurn function
     * decideds my turn and outputs the request
     * @param energy my robot's current energy
     * @param data the oppData array of all robots alive
     * @return the turn request object
     */
    public TurnRequest takeTurn(int energy, OppData[] data){
        this.turnCount++;
        this.energy = energy;
        //updates my StefanOppData array besed off of the passed in OppData
        for(int i = 0; i < data.length; i++){

            this.data[i].updateData(data[i]);
            if(data[i].getID() == this.getID()){
                this.health = data[i].getHealth();
            }
        }
        
        this.attacking = true;
        //find the target to attack
        int target = this.getBest();
        //resort the array to be back in ID order
        this.sortID();
        //get the targets postion
        int[] pos = moveTarget(target);
        //is it within my range, if not dont attack
        if(pos[2] == 0){ 
            target = -1;
        }
        //return the request
        return new TurnRequest(pos[0], pos[1], target, this.getNumRounds());
    }


    /**
     * my definition of the FigherRobot battleResults
     * updates the StefanOppData difficulty value of opponent in fight
     * @param healthLost how much health my robot lost
     * @param oppID the opponents ID
     * @param oppHealthLost how much health they lost 
     * @param numRoundsFought the number of rounds fought
     */
    public void battleResult(int healthLost, int oppID, int oppHealthLost, int numRoundsFought){
        if(oppID != -1){ 
            this.data[oppID].updateDiff(healthLost, oppHealthLost, numRoundsFought);
        }
        this.health -= healthLost;
        

    }



    /** 
     * takes in my robots target, outputs my target to get me their, adjusted for my max number of moves
     * @param oppID which robot am I targeting
     * @return int[] where index 0 is the avenue, 1 is the street and 2 is wether I actually made it or not and wether to attack
     * @pre array is sorted by ID
     * 
    */
    private int[] moveTarget(int oppID){
        int[] arr = new int[3];
        int targetA, targetS, diff;
        //is it farther than my max moves per turn?
        if(this.data[oppID].getDistance() > this.getNumMoves()){
            //is just getting to their avenue more than my max moves per turn?
            if(Math.abs(this.data[oppID].getAvenue() - this.getAvenue()) > this.getNumMoves()){
                //move along the avenue as far as I can
                targetA = this.getAvenue() + sgn((this.data[oppID].getAvenue() - this.getAvenue()))*this.getNumMoves();
                targetS = this.getStreet();
            }
            else{
                //move to their avenue then as far along the street as I can
                targetA = this.data[oppID].getAvenue();
                diff = this.getNumMoves() - Math.abs(this.data[oppID].getAvenue() - this.getAvenue());
                targetS = this.getStreet() + sgn((this.data[oppID].getStreet() - this.getStreet()))*diff;
            }
            arr[0]= targetA;
            arr[1]= targetS;
            //dont attack
            arr[2] = 0;
        }
        else{
            //go to them
            arr[0]=this.data[oppID].getAvenue();
            arr[1]= this.data[oppID].getStreet();
            arr[2] = 1;
        }
        return arr;
    }


    /**
     * find the best robot for me to attack
     * @return the best robot for me to attack
     */
    private int getBest(){
        //generated the weighted score for every robot
        this.generateWeighted();
        //sort the weighted scores
        this.sortWeighted();
        int index = 0;
        //make sure its not my robot
        if(this.data[index].getID() == this.getID()){
            index++;
        }
        //return id
        return this.data[index].getID();
        
    }


    /**
     * sorts the StefanOppData array based on ID from 0-max using an insertion sort
     */
    private void sortID(){ 
        StefanOppData temp = this.data[0];
        int index = 0;
        for(int i = 0; i<this.data.length; i++){
            temp = this.data[i];
            index = i;
            for(int j = i; j < this.data.length; j++){
                if(this.data[j].getID() < temp.getID()){
                    temp = this.data[j];
                    index = j;
                }
            }
            this.data[index]= this.data[i];
            this.data[i] = temp;
        }
    }


    /** 
     * sorts the StefanOppData array based on the weight values using an insertion sort
    */
    private void sortWeighted(){
        StefanOppData temp = this.data[0];
        int index = 0;
        for(int i = 0; i<this.data.length; i++){
            temp = this.data[i];
            index = i;
            for(int j = i; j < this.data.length; j++){
                if(this.data[j].getWeighted() < temp.getWeighted()){
                    temp = this.data[j];
                    index = j;
                }
            }
            this.data[index]= this.data[i];
            this.data[i] = temp;
        }

    }



    /** 
     * calculate the weighted values for every elemet in the data array
    */
    private void generateWeighted(){
        //calls function for each index in the array
        for(int i =0; i < this.data.length; i++){
            this.data[i].setWeighted(this.calcWeight(this.data[i]));
        }
    }


    /**
     * calulate the weight value of the passed in robot
     * @param data StefanOppData element of the target robot
     * @return the weight value
     */
    private double calcWeight(StefanOppData data){
        return this.weightHealth(data.getHealth()) + this.weightDist(data.getDistance()) + this.weightMoveDist(data.getMaxMoves()) + this.weightDiff(data.getDiff(), data.getTotalRounds());
    }


    /**
     * Weights the distance from my robot
     * @param dist distance from my robot
     * @return weighted value
     */
    private double weightDist(int dist){
        //expoential function which gets larger as energy gets smaller and distance gets bigger
        return (Math.pow(((100.0/this.energy)/this.OPP_DIST_SCALER), (double)dist/this.getNumMoves()));
    }


    /**
     * Weights the movedist 
     * @param maxNumMoves the movDist value
     * @return  weighted value
     */
    private double weightMoveDist(int maxNumMoves){ 
        //translated sigmoid function which creates a negative s-curve correlation between the maximum observed move distance and oppenent difficulty 
        return (-1.0/(1+Math.pow(Math.E, (maxNumMoves-5) *-1)) +1.0) * this.MOVE_DIST_SCALER;
    }


    /**
     * Weights the difficulty
     * @param diff the difficulty value
     * @param accuracy the accuracy value
     * @return weighted score
     */
    private double weightDiff(double diff, int accuracy){ 
        return (-1.0/(1+Math.pow(Math.E, (diff) *-4.0)) +1.0) * this.DIFF_SCALER * (Math.sqrt(accuracy + 1)/this.DIFF_ACCUARACY_SCALER);
    }


    /**
     * Weights the health 
     * @param health The health value
     * @return weighted score
     */
    private double weightHealth(int health){ 
        return health/this.HEALTH_WEIGHT;
    }


    /**
     * finds Number of rounds to fight
     * @return number of rounds to fight
     */
    private int getNumRounds(){ 
        return this.getAttack();
    }
    


    /**
     * Helper method, finds the sign of number
     * @param num the number
     * @return -1, 0 or 1 depending on the sign of the num
     */
    private static int sgn(int num){ 
        if(num>0){ 
            return 1;
        }
        else if(num < 0){
            return -1;
        }
        else{
            return 0;
        }
    }
}
