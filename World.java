

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author coracoleman
 */
abstract class World implements State 
{
    //set start amount of resources
    public abstract void setInitialResources();
    //return resources 
    public abstract Map<String,Integer> getResources();
    //modify amount of resources
    public abstract void modifyResources(String name, Integer amount);
    //set start amount/kind of idlemon
    public abstract void setStartIdlemon(ArrayList<Idlemon> inputIdleMonArray);
    //return idlemon 
    public abstract ArrayList<Idlemon> getIdlemon();
    //modify amount of idlemon
    public abstract void addIdlemon(Idlemon idleMonToAdd);
    //check if challenge has been satisfied
    public abstract Boolean checkWin();    
    
    public abstract String getName();
   
}
