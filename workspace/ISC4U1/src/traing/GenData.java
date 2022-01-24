package traing;
import java.util.*;


/** 
 * A data class to hold and compute robot constants to be used in genetic training
*/
public class GenData {
    public int attack, defence, numMoves;
    public double MOVE_DIST_SCALER, OPP_DIST_SCALER, DIFF_SCALER, DIFF_ACCUARACY_SCALER, HEALTH_WEIGHT;

    /**
     * Constructor
     * @param attack robots attack stat
     * @param defence robots defence stat
     * @param numMoves robots numMoves
     * @param MOVE_DIST_SCALER robots move_dist_scaler
     * @param OPP_DIST_SCALER robots OPP_DIST_SCALER
     * @param DIFF_SCALER robots DIFF_SCALER
     * @param DIFF_ACCUARACY_SCALER robots DIFF_ACCURACY_SCALER
     * @param HEALTH_WEIGHT robots HEALTH_WEGIHT
     */
    public GenData(int attack, int defence, int numMoves, double MOVE_DIST_SCALER, double OPP_DIST_SCALER, double DIFF_SCALER, double DIFF_ACCUARACY_SCALER, double HEALTH_WEIGHT) {
        this.attack = attack;
        this.defence = defence;
        this.numMoves = numMoves;
        this.MOVE_DIST_SCALER = MOVE_DIST_SCALER;
        this.OPP_DIST_SCALER = OPP_DIST_SCALER;
        this.DIFF_SCALER = DIFF_SCALER;
        this.DIFF_ACCUARACY_SCALER = DIFF_ACCUARACY_SCALER;
        this.HEALTH_WEIGHT = HEALTH_WEIGHT;
    }

    /** 
     * Defualt constructor
    */
    public GenData(){}


    /**
     * Creates new generation based off of previous
     * @param config
     * @param deathOrder
     * @param genNum
     */
    public static void modify(GenData[] config, int[] deathOrder, int genNum){
        GenData[] best = new GenData[3];
        //find best
        for(int i = 0; i < best.length; i++){
            System.out.println(deathOrder[i]);
            best[i] = config[deathOrder[i]];
        }

         System.out.format("best of: %d| %d, %d, %d, %f, %f, %f, %f, %f\n", genNum,best[0].attack, best[0].defence, best[0].numMoves, best[0].MOVE_DIST_SCALER, best[0].OPP_DIST_SCALER, best[0].DIFF_SCALER, best[0].DIFF_ACCUARACY_SCALER, best[0].HEALTH_WEIGHT);
        
		
        //mix
        config[0] = best[0];
        config[1] = best[1];
        config[2] = best[2];
        config[3] = mix(best[0], best[1]);
        config[4] = mix(best[1], best[2]);
        config[5] = mix(best[2], best[0]);
        config[6] = mix(best[0], best[2]);
        config[7] = mix(best[1], best[0]);
        config[8] = mix(best[2], best[1]);

        int[] data;
        //modify each stat for non best robots
        for(int i = 2; i < config.length; i++){
            data = newStats(config[i].attack, config[i].defence, config[i].numMoves);
            config[i].attack = data[0];
            config[i].defence = data[1];
            config[i].numMoves = data[2];
            config[i].MOVE_DIST_SCALER = modifyMoveDist(config[i].MOVE_DIST_SCALER);
            config[i].OPP_DIST_SCALER = modifyOppDist(config[i].OPP_DIST_SCALER);
            config[i].DIFF_SCALER = modifyDiff(config[i].DIFF_SCALER);
            config[i].DIFF_ACCUARACY_SCALER = modifyDiffAccur(config[i].DIFF_ACCUARACY_SCALER);
            config[i].HEALTH_WEIGHT = modifyHealth(config[i].HEALTH_WEIGHT);

        }

        for(int i = 0; i<config.length; i++){ 
            System.out.format("%d| %d, %d, %d, %f, %f, %f, %f\n", genNum+1,config[i].attack, config[i].defence, config[i].numMoves, config[i].MOVE_DIST_SCALER, config[i].OPP_DIST_SCALER, config[i].DIFF_SCALER, config[i].DIFF_ACCUARACY_SCALER, config[i].HEALTH_WEIGHT);
        }
    }


    /**
     * Randomly returns a + or - 1
     * @return either -1 or +1
     */
    public static int randDir(){
        Random rand = new Random();
        return (rand.nextInt(2) *2) -1;
    }


    /**
     * modifies the 3 robot stats
     * @param a attack stat
     * @param d defence stat
     * @param m num move stats
     * @return int[] of {a,d,m}
     */
    public static int[] newStats(int a, int d, int m){
        Random rand = new Random();
        //desides which to modify
        int target = rand.nextInt(3);
        int sub_t = rand.nextInt(2);
        int change = 1*randDir();
        //modfiy
        if(target ==0){
            //bounds check
            if(a + change > 10 || a + change < 0){ 
                change *= -1;
            }
            if(sub_t == 0){
                if(d - change > 10 || d - change < 0){
                    sub_t = 1;
                }
                else{ 
                    d -= change;
                }
            }
            if(sub_t == 1){
                if(m - change > 10 || m - change < 0){
                    sub_t = 2;
                }
                else{
                    m -= change;
                }
            }
            if(sub_t != 2){
                a += change;
            }
        }
        else if( target == 1){
            if(d + change > 10 || d + change < 0){ 
                change *= -1;
            }
            if(sub_t == 0){
                if(a - change > 10 || a - change < 0){
                    sub_t = 1;
                }
                else{ 
                    a -= change;
                }
            }
            if(sub_t == 1){
                if(m - change > 10 || m - change < 0){
                    sub_t = 2;
                }
                else{
                    m -= change;
                }
            }
            if(sub_t != 2){
                d += change;
            }
        }
        else{ 
            if(m + change > 10 || m + change < 0){ 
                change *= -1;
            }
            if(sub_t == 0){
                if(d - change > 10 || d - change < 0){
                    sub_t = 1;
                }
                else{ 
                    d -= change;
                }
            }
            if(sub_t == 1){
                if(a - change > 10 || a - change < 0){
                    sub_t = 2;
                }
                else{
                    a -= change;
                }
            }
            if(sub_t != 2){
                m += change;
            }
        }
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = d;
        arr[2] = m;
        return arr;
    }
    

    /**
     * changes a move dist by a random amount
     * @param moveDist moveDist value
     * @return modified value
     */
    private static double modifyMoveDist(double moveDist){ 
        Random rand = new Random();
        double adjust = rand.nextDouble()*randDir();
        return moveDist += adjust;
    }


    /**
     * Modify oppDist scaler
     * @param oppDist 
     * @return modfied value
     */
    private static double modifyOppDist(double oppDist){
        Random rand = new Random();
        double adjust = 0.1*randDir();
        //bounds check
        if(oppDist + adjust >= 1.0 || oppDist + adjust <= 0.0){
            adjust *= -1;
        }
        return oppDist + adjust;
    }


    /**
     * modify the diffScaler
     * @param diffScaler value
     * @return modified value
     */
    private static double modifyDiff(double diffScaler){
        Random rand = new Random();
        double adjust = rand.nextDouble()*randDir();
        return diffScaler+= adjust;
    }


    /**
     * modify accuracy scaler
     * @param diffAccur value
     * @return modified value
     */
    private static double modifyDiffAccur(double diffAccur){
        Random rand = new Random();
        double adjust = rand.nextDouble()*randDir();
        if(diffAccur + adjust <= 0.0){
            adjust *= -1;
        }
        return diffAccur + adjust;
    }


    /**
     * Modify health value
     * @param health value
     * @return modify value
     */
    private static double modifyHealth( double health){
        Random rand = new Random();
        double adjust = rand.nextDouble()*randDir();
        if(health + adjust <= 0.0){
            adjust *= -1;
        }
        return health + adjust;
    }



    /**
     * Mix two GenData 
     * @param a first GenData
     * @param b second GenData
     * @return mixed gendata
     */
    public static GenData mix(GenData a, GenData b){ 
        //find where to mix
        Random rand = new Random();
        int split = rand.nextInt(7);
        GenData output = new GenData();
        if(split > 0){
            output.attack = a.attack;
            output.defence = a.defence;
            output.numMoves = a.numMoves;
        }
        else{ 
            output.attack = b.attack;
            output.defence = b.defence;
            output.numMoves = b.numMoves;
        }
        if(split > 1){
            output.MOVE_DIST_SCALER = a.MOVE_DIST_SCALER;
        }
        else{ 
            output.MOVE_DIST_SCALER = b.MOVE_DIST_SCALER;
        }
        if(split > 2){
            output.OPP_DIST_SCALER = a.OPP_DIST_SCALER;
        }
        else{ 
            output.OPP_DIST_SCALER = b.OPP_DIST_SCALER;
        }
        if(split > 3){
            output.DIFF_SCALER = a.DIFF_SCALER;
        }
        else{ 
            output.DIFF_SCALER = b.DIFF_SCALER;
        }
        if(split > 4){
            output.DIFF_ACCUARACY_SCALER = a.DIFF_ACCUARACY_SCALER;
        }
        else{ 
            output.DIFF_ACCUARACY_SCALER = b.DIFF_ACCUARACY_SCALER;
        }
        if(split > 5){
            output.HEALTH_WEIGHT = a.HEALTH_WEIGHT;
        }
        else{ 
            output.HEALTH_WEIGHT = b.HEALTH_WEIGHT;
        }
        return output;
    }
}
