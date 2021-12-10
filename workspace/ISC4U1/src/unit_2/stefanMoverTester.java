package unit_2;
import becker.robots.*;
import java.util.*;

/** 
 * an tester application class for the StefanMoverRobot
*/
public class stefanMoverTester {
    public static void main(String[] args){ 
        //setup city and robot
        City oakville = new City(2,10);
		StefanMoverRobot mover = new StefanMoverRobot(2,oakville,1,2,Direction.EAST); 
        oakville.showThingCounts(true);

        //build house
        Wall[] house = new Wall[3];
        house[0] = new Wall(oakville,1,1,Direction.NORTH);
        house[1] = new Wall(oakville,1,1,Direction.WEST);
        house[2] = new Wall(oakville,1,1,Direction.SOUTH);

        //place packages
        Random rand = new Random();
        ArrayList<Thing> packs = new ArrayList<Thing>();
        for(int i = 0; i < rand.nextInt(5)+1; i++){
            packs.add(new Thing(oakville,1,9));
        }
        
        //run the robot
        mover.clearPackages();

    }
}
