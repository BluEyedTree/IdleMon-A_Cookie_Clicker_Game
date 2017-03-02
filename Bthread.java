/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tom
 */
public class Bthread implements Runnable {
    World thisWorld;
    private Thread t;
   
    public Bthread(World world){
        
        this.thisWorld = world;
        
    }
    
    public void run(){
        Boolean notWon = true;
        while(notWon){
        try {
            if(thisWorld.checkWin()){
            notWon = false;
            
        }
        ArrayList<Idlemon> IdleArray = thisWorld.getIdlemon();
       
        for(Idlemon Idle: IdleArray){
            
            Idle.convert();
        }
        //System.out.println("test");
            Thread.sleep(1400);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bthread.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }
    
    
    
   
    
    
}
