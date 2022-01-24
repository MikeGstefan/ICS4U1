package traing;
import becker.robots.*;
import java.util.*;


public class TestFighterRobot extends FighterRobot{
    private static final int attack =3;
    private static final int numMoves =4;
    private static final int defence =3;
    private int health;

	public TestFighterRobot (City c, int a, int s, Direction d, int id, int health){
		super(c,a,s,d,id,attack,numMoves,defence);
        this.health = health;
	}

    public void goToLocation(int a, int s){    }

    public TurnRequest takeTurn(int energy, OppData[] data){
        return new TurnRequest(this.getAvenue(), this.getStreet(), -1, -1);
    }

    public void battleResult(int healthLost, int oppID, int oppHealthLost, int numRoundsFought){

    }

}
