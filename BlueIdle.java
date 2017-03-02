

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tom
 */
import java.util.ArrayList;
import java.util.Arrays;
public class BlueIdle extends Idlemon {

       
    public BlueIdle(World inputWorld){
       super("BlueIdle",1.0,20.0,30.0,10.0,new ArrayList<String>(Arrays.asList(new String[] { "flame" })),new ArrayList<String>(Arrays.asList(new String[] { "water" })),inputWorld);
        /**
         * Blue IdleMon convert flame to water.
         * The first arrayList fed in is the resource the idlemon consumes
         * The second arrayList fed in is the resource the idlemon produces
         * This class must be fed in the world that is to be manipulated to store information
         */
        

       
    }
    
   public Idlemon buyNew(){
         
         world.modifyResources("water", -costToBuy); //Subtracts the cost from the world resources
         world.addIdlemon(new BlueIdle(world));
        return(new BlueIdle(world));
     }
    
}
