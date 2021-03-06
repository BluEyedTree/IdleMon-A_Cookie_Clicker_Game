


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tom
 */
public abstract class Idlemon {
    String Name;
    double currentLevel;
    double costToBuy;
   
    public ArrayList<String> ConsumeResources = new ArrayList<>();
    public ArrayList<String> ProduceResources = new ArrayList<>();
    public World world;
    public double consumeCost;
    public double produceAmount;
    public Idlemon(String name, double CurrentLevel, double consumeCost, double produceAmount, Double Cost, ArrayList<String> produceResources,ArrayList<String> consumeResources, World world){
        this.Name = name;
        this.currentLevel = CurrentLevel;
        for(String resourceToConsume: consumeResources){
            
            this.ConsumeResources.add(resourceToConsume);
            
        }
        for(String resourceToProduce: produceResources){
            this.ProduceResources.add(resourceToProduce);
        }
        this.world = world;
        this.consumeCost = consumeCost;
        this.produceAmount = produceAmount;
        this.costToBuy = Cost;
    }
  public void levelUp(){
        this.currentLevel +=1;
        world.modifyResources(ConsumeResources.get(0), -costToBuy);
    }
    
    public void consume(){
        for (String resourceToConsume: this.ConsumeResources){
            world.modifyResources(resourceToConsume, -consumeCost*(1/currentLevel));
            
        }
    }
    
    public void produce(){
        
       for (String resourceToConsume: this.ConsumeResources){
            world.modifyResources(resourceToConsume, produceAmount*currentLevel);
            
        }
    }
    
    public void convert(){
        
        consume();
        produce();
        produce();
        special(); //a hook in our template method 
    }
    
    public void special(){}; 
    //This should be overiden by a subclass to add a special feature to the convert method. 
    
    
    public double getLevel(){
        return this.currentLevel;
    }
    
    
    public Map getCost(){
         //Change this to change the price
        Map<ArrayList, Double> costMap = new HashMap();
        costMap.put(this.ProduceResources,costToBuy);
        return costMap;
    }
    
    public abstract Idlemon buyNew();
    
    
}