

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author coracoleman
 */
public class World1 extends World
{
    //name of World challenge
    String name = "FleurDeFlamme";
    
    public int counter=0;
    //map of resources
    Map<String,Integer> resources = new HashMap<>();
    //arraylist of idlemon
    ArrayList<Idlemon> idlemon = new ArrayList<Idlemon>();
    //amount of flame resource
    Integer flame;
    //amount of water resource
    Integer water;
    //amount of grass resource
    Integer grass;
    //take note of start time
    long startTime;
    //take note of current time
    long now;
    //take note of total time
    public long elapsed;
    

    //constructor
    public void World1()
    {
        //startTime = System.nanoTime();
    }
    public String getName(){
        return name;
    }
    //set start amount of resources
    @Override
    public void setInitialResources() 
    {
        //initial values of resources
        startTime = System.nanoTime();
        flame = 26;
        water = 68;
        grass = 115;
        resources.put("flame", flame);
        resources.put("water", water);
        resources.put("grass", grass);
    }

    //return resources
    @Override
    public Map<String, Integer> getResources() 
    {
        return resources;   
    }
    
    //modify amount of resources
    @Override
    public void modifyResources(String name, Integer amount)
    {
        if(name.equals("flame"))
        {
            resources.put("flame", resources.get("flame") + amount);   
        }
        if(name.equals("water"))
        {
            resources.put("water", resources.get("water") + amount);     
        }
        if(name.equals("grass"))
        {
            resources.put("grass", resources.get("grass") + amount);
        }
    }

    //set start amount/kind of idlemon
    @Override
    public void setStartIdlemon(ArrayList<Idlemon> inputIdleMonArray) 
    {
        for(Idlemon idleman: inputIdleMonArray){
            idlemon.add(idleman);
        }
    }

    //return idlemon
    @Override
    public ArrayList<Idlemon> getIdlemon() 
    {
        //add code
        return idlemon;
    }

    //modify amount of idlemon
    @Override
     public void addIdlemon(Idlemon idleMonToAdd) 
    {
        idlemon.add(idleMonToAdd);
    }

    //check if challenge has been satisfied
    @Override
    public Boolean checkWin() 
    {
        //satisfactory amounta to be used to check the win
        Integer minFlame = 1300;
        Integer minWater = 370;
        Integer minGrass = 300;
        
        //checks if minimum reqs. are satisfied
        if((resources.get("flame") >= minFlame) & (resources.get("water") >= minWater) & (resources.get("grass") >= minGrass))
        {
            //System.out.println("Resources satisfied!");
            //record finish time
            
           
            
            
            
              
            //System.out.println("Challenge "+name+" completed in "+TimeUnit.NANOSECONDS.toMinutes(elapsed)+" minutes!");
            counter +=1;
            if (counter ==1){
                now = System.nanoTime();
            }
            return true;
        }
        else
        {
            //System.out.println("Not quite...");
            return false;
        }
    }

    //@Override
    public void update() 
    {
        //could be implemented for multiple players
    }

    //@Override
    public void addObserver() 
    {
        //could be implemented for multiple players
    }

    //returns the time the challlenge was completed in
    //@Override
    public long timeCompleted() 
    {      
        elapsed = (now - startTime);
        
        return TimeUnit.SECONDS.convert(elapsed, TimeUnit.NANOSECONDS);     
    }
    
}
