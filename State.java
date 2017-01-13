

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author coracoleman
 */
public interface State 
{   
    //could be implemented for multiple players
    public void update();
    //could be implemented for multiple players
    public void addObserver();
    //returns the time the challlenge was completed in 
    public long timeCompleted();
    
}
