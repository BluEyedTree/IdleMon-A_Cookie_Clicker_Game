

import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tom
 */
public class GreenIdle extends Idlemon {
    
       
    public GreenIdle(World inputWorld){
       super("GreenIdle",1.0,20.0,30.0,100.0,new ArrayList<String>(Arrays.asList(new String[] { "water" })),new ArrayList<String>(Arrays.asList(new String[] { "grass" })),inputWorld);
        /**
         * Green IdleMon convert water to grass.
         * The first arrayList fed in is the resource the idlemon consumes
         * The second arrayList fed in is the resource the idlemon produces
         * This class must be fed in the world that is to be manipulated to store information
         */
       
    }
    
      public Idlemon buyNew(){
         
         world.modifyResources("grass", -costToBuy);
         world.addIdlemon(new GreenIdle(world));
        return(new GreenIdle(world));
     }
}
