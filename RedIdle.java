


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
public class RedIdle extends Idlemon {
   
    
    public RedIdle(World inputWorld){
      
       super("RedIdle",1.0,20.0,30.0,100.0,new ArrayList<String>(Arrays.asList(new String[] { "grass" })),new ArrayList<String>(Arrays.asList(new String[] { "flame" })),inputWorld);
        /**
         * Blue IdleMon converts grass to flame.
         * 
         * The first arrayList fed in is the resource the idlemon consumes
         * The second arrayList fed in is the resource the idlemon produces
         * This class must be fed in the world that is to be manipulated to store information
         */
        

       
    }
    
     public Idlemon buyNew(){
         
         world.modifyResources("flame", -costToBuy);
         world.addIdlemon(new RedIdle(world));
         return(new RedIdle(world));
     }
    
    
    
}