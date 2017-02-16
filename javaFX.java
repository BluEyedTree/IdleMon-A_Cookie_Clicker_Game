import java.awt.Label;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
/**
 *
 * @author Tom
 */
public class javaFX extends Application 

{

 Idlemon CurrentIdleMon;
 Map IdleButton;
 

    @Override
    public void start(Stage theStage) 
    {
        //makes the JavaFX and world objects
        World testworld = new World1();
        //World testworld = new World2(); //uncomment this line and delete the one above to load world 2
        theStage.setTitle(testworld.getName());

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 500, 500 );
        //Image restart = new Image("restart.png");
       
        //Creates Idlemon array
        ArrayList<Circle> test = new ArrayList<>();
        ArrayList<Circle> temp = new ArrayList<>();
        ArrayList<Circle> permanent = new ArrayList<>();
        root.getChildren().add( canvas );
        Circle targetData = new Circle(100,100,32);
       
        Circle BuyCircle = new Circle(380,450,32);
        Circle LvlUpCircle = new Circle(450,450,32);
        test.add(targetData);
        
         //Bthread updater = new Bthread(testworld); 
         //updater.start();
         
         
         
        IntValue points = new IntValue(0);
        
        //sets up the world
        testworld.setInitialResources();
        Map map = testworld.getResources();
        Idlemon BIdle = new BlueIdle(testworld);
        Idlemon RIdle = new RedIdle(testworld);
        Idlemon GIdle = new GreenIdle(testworld);
        ArrayList<Idlemon> IdleMonArray = new ArrayList<>();
        IdleMonArray.add(BIdle);
        IdleMonArray.add(RIdle);
        IdleMonArray.add(GIdle);
        testworld.setStartIdlemon(IdleMonArray);
        //THREAD PLAY
        Runnable updater = new Bthread(testworld);
         new Thread(updater).start();
        
        //Creates a hashmap of Idlemon and their associated buttons
        Map<Circle,Idlemon> IdleButton = new HashMap<Circle,Idlemon>();
        for(Idlemon I: testworld.getIdlemon()){
            IdleButton.put(new Circle(400 * Math.random(),400 * Math.random(),30),I);
        }
       
        
        
        
        
        theScene.setOnMouseClicked(
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent e)
                {
                    
                 for(Map.Entry<Circle, Idlemon> currentEntry : IdleButton.entrySet()){ 
                    
                 
                    //If an Idlemon is clicks it is set to be the CurrentIdleMon
                    //The currentIdlemon has its buy and level up functions called
                    if ( currentEntry.getKey().containsPoint(e.getX(), e.getY()))
                    {
                       
                       
                   
                        CurrentIdleMon = currentEntry.getValue();
                        double x = 50 + 400 * Math.random(); 
                        double y = 50 + 400 * Math.random();
                       
                        targetData.setCenter(x,y);
                        temp.add(new Circle(400 * Math.random(),400 * Math.random(),32));
                       
                    }
                    
                    
                        
                }
                
                //Deals with the case the Level Up Circle is pressed
                     if ( LvlUpCircle.containsPoint( e.getX(), e.getY() ) )
                    {
                       if(CurrentIdleMon!=null){ //Prevents null pointer excepts
                           if(testworld.getResources().get(CurrentIdleMon.ConsumeResources.get(0))>50){
                                CurrentIdleMon.levelUp();
                           }
                       }
                     //Deals with the case the Buy Circle is pressed
                    }
                      if ( BuyCircle.containsPoint( e.getX(), e.getY() ) )
                    {
                       if(CurrentIdleMon!=null){ //prevents null pointer exceptions
                           if(testworld.getResources().get(CurrentIdleMon.ConsumeResources.get(0))>50){
                           double x = 50 + 400 * Math.random(); 
                           double y = 50 + 400 * Math.random();
                           IdleButton.put(new Circle(x,y,32), CurrentIdleMon.buyNew());
                       
                       }
                       }
                      
                    }
                
                
                
                }
            });

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Font theFont = Font.font( "Helvetica", FontWeight.BOLD, 24 );
        gc.setFont( theFont );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(1);

        
		
        new AnimationTimer()
                
        {
            
            public void handle(long currentNanoTime)
            {
           
           
            
                //Clear the canvas
                gc.setFill( new Color(0.85, 0.85, 1.0, 1.0));
                gc.fillRect(0,0, 512,512);
                
          
                for(Circle targetData: IdleButton.keySet()){
                
                //Creates Image objects to be used    
		Image grassImage = new Image( "grass.png" );
                Image fireImage = new Image( "fire.png" );
                Image waterImage = new Image( "water.png" );
                
                //Creates Circles for the BlueIdlemon
                if(IdleButton.get(targetData).Name.equalsIgnoreCase("BlueIdle")){
                gc.drawImage( waterImage, 
                    targetData.getX()+(10) - targetData.getRadius(),
                    targetData.getY()+(10) - targetData.getRadius() );
                    String pointsText = "" + IdleButton.get(targetData).getLevel();
                    gc.strokeText( pointsText, targetData.getX()+10, targetData.getY()+20);
                }
                 //Creates Circles for the RedIdlemon
                else if(IdleButton.get(targetData).Name.equalsIgnoreCase("RedIdle")){
                     gc.drawImage( fireImage, 
                    targetData.getX()+(10) - targetData.getRadius(),
                    targetData.getY()+(10) - targetData.getRadius() );
                    String pointsText = "" + IdleButton.get(targetData).getLevel();
                    gc.strokeText( pointsText, targetData.getX()+10, targetData.getY()+20);
                }
                 //Creates Circles for the GreenIdlemon
                else if(IdleButton.get(targetData).Name.equalsIgnoreCase("GreenIdle")){
                    gc.drawImage( grassImage, 
                    targetData.getX()+(10) - targetData.getRadius(),
                    targetData.getY()+(10) - targetData.getRadius() );
                    String pointsText = "" + IdleButton.get(targetData).getLevel();
                    gc.strokeText( pointsText, targetData.getX()+10, targetData.getY()+20);
                }
                                }
                                
                                
                //Images and drawing of the BuyNew and LevelUp buttons      
		Image BuyImage = new Image( "BuyNew.png" );
                Image LevelUp = new Image( "LevelUP.png" );
                gc.drawImage( BuyImage, 
                    BuyCircle.getX() - BuyCircle.getRadius(),
                    BuyCircle.getY() - BuyCircle.getRadius() );
                gc.drawImage( LevelUp, 
                    LvlUpCircle.getX() - LvlUpCircle.getRadius(),
                    LvlUpCircle.getY() - LvlUpCircle.getRadius() );
                                
               
             
                                
                //The Blue background color                 
                gc.setFill( Color.BLUE );
                
                //Changes the label if the game is won
                if(testworld.checkWin()){
                 Map ResourceMap = testworld.getResources();
                  
                String message = "Challenge" +  " completed in " + testworld.timeCompleted() + " seconds";
                gc.setFill( Color.BLUE );
                gc.fillText( message, 50, 36 );
                gc.strokeText( message, 50, 36 );
                }
                else{
                Map ResourceMap = testworld.getResources();
                String message = "Flame: " + ResourceMap.get("flame") +"  Grass: "+ ResourceMap.get("grass")+ "  Water: " + ResourceMap.get("water") ;
                
                gc.fillText( message, 50, 36 );
                gc.strokeText( message, 50, 36 );
                }
               //Sets the location of the message label
               
            }
        }.start();


        theStage.show();
    }
}