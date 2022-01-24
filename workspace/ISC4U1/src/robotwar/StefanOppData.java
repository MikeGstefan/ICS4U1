package robotwar;



/**
 * My extension of the OppData class 
 * @version 01/17/2022
 * @author Mike Stefan
 */ 
public class StefanOppData extends OppData{
    private int maxNumMoves = 0, distance = 0, moveDist = 0;
    private int lastA, lastS;
    private double diff = 0.0;
    private boolean configed = false;
    private StefanFighterRobot robot;
    private int totalRoundsFought = 0;
    private double weighted = 0.0;
    

    /**
     * Constructor
     * @param id the robots id
     * @param a the robots current avenue
     * @param s the robots current street
     * @param health the robots current health
     * @param robot refrence to the robot to compare distances with (mine)
     */
    public StefanOppData (int id, int a, int s, int health, StefanFighterRobot robot)
	{
        super(id, a, s, health);
        this.lastA = a;
        this.lastS = s;
        this.robot =robot;
	}
    


    /**
     * Updates the data contained based off of the OppData object
     * @param data OppData object
     */
    public void updateData(OppData data){
        //how far did they move from last turn
        this.moveDist = Math.abs(data.getAvenue() - this.lastA) + Math.abs(data.getStreet() - this.lastS);
        //set data to use to for this calculation next turn
        this.lastA = this.getAvenue();
        this.lastS = this.getStreet();
        this.setAvenue(data.getAvenue()); 
        this.setStreet(data.getStreet());
        this.setHealth(data.getHealth());

        //distance from my robot
        this.distance = Math.abs(this.robot.getStreet() - this.getStreet()) + Math.abs(this.robot.getAvenue() - this.getAvenue());
        //if not the first turn, compare to the max number of moves in a single turn
        if(this.moveDist > this.maxNumMoves && this.configed){
            this.maxNumMoves = this.moveDist;
        }
        //used to figure out if its the first time updating or not
        this.configed = true;
    }


    /**
     * Update the difficuly of the robot after a fight, used in the battleResult function
     * @param healthLost health my robot lost
     * @param oppHealthLost health their robot lost
     * @param numRoundsFought number of rounds we fought
     */
    public void updateDiff(int healthLost, int oppHealthLost, int numRoundsFought){
        this.diff = ((double)(oppHealthLost-healthLost) + (this.diff*this.totalRoundsFought))/(double)(numRoundsFought + this.totalRoundsFought);
        this.totalRoundsFought += numRoundsFought;
    }


    /**
     * setter for the weighted value
     * @param weighted weighted value
     */
    public void setWeighted(double weighted){
        this.weighted = weighted;
    }


    /**
     * getter for the weighted value
     * @return weighted value
     */
    public double getWeighted(){
        return this.weighted;
    }


    /**
     * getter for the last avenue
     * @return last avenue
     */
    public int getlastA(){
        return this.lastA;
    }


    /**
     * getter for the last street
     * @return last street
     */
    public int getlastS(){
        return this.lastS;
    }


    /**
     * getter for the distance
     * @return distance
     */
    public int getDistance(){
        return this.distance;
    }


    /**
     * getter for the moveDist
     * @return moveDist
     */
    public int getMoveDist(){
        return this.moveDist;
    }


    /**
     * getter for the maximum observed move distance
     * @return maxNumMoves
     */
    public int getMaxMoves(){ 
        return this.maxNumMoves;
    }


    /**
     * getter for the difficuly rating
     * @return difficulty
     */
    public double getDiff(){ 
        return this.diff;
    }


    /**
     * getter for total number of rounds fought
     * @return total rounds fought
     */
    public int getTotalRounds(){
        return this.totalRoundsFought;
    }



}