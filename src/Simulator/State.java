/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulator;

/**
 *
 * @author Kris
 */
class State {
    private boolean doorState = false;
    private boolean bellState = false;
    private boolean floor1ButtonState = false;
    private boolean floor2ButtonState= false;
    private boolean[] floorContent = new boolean[2];
    private boolean liftContent = false;
    private int liftPos = 1;
    private boolean liftButtonTo1State = false;
    private boolean liftButtonTo2State = false;
    private int currentTime = 0;
    
    public void print(){
        
    }
    public void changeDoorState(){
        doorState ^= true;
        if(doorState){
            System.out.println("Doors open.");
        }else System.out.println("Doors close.");
        print();
    }
    public void changeBellState(){
        bellState ^= true;
        if(bellState){
            System.out.println("Ring, ring, ring...");
        }else System.out.println("No more ring.");
        print();
    }
    public void changeF1buttonState(){
        floor1ButtonState ^= true;
        if(floor1ButtonState){
            System.out.println("Floor 1 button is pressed.");
        }else System.out.println("Floor 1 button is unpressed.");
        print();
    }
    public void changeF2buttonState(){
        floor2ButtonState ^= true;
        if(floor2ButtonState){
            System.out.println("Floor 2 button is pressed.");
        }else System.out.println("Floor 2 button is unpressed.");
        print();
    }     
    public void changeFloorContent(int i){
        floorContent[i-1] ^= true;
        if(floorContent[i-1]){
            System.out.println("Floor " + i + " has a passenger.");
        }else System.out.println("Floor " + i + " is empty.");
        print();
    } 
    public void changeLiftPos(int p){
        liftPos = p;
        if(liftPos == 1){
            System.out.println("Lift at floor " + p);
        }else System.out.println("Lift at floor " + p);
        print();
    }
    public void changeLiftContent(){
        liftContent ^= true;
        if(liftContent){
            System.out.println("Lift full.");
        }else System.out.println("Lift empty.");
        print();
    }
    public void changeLbuttonTo1State(){
        liftButtonTo1State ^= true;
        if(liftButtonTo1State){
            System.out.println("Go to 1 pressed.");
        }else System.out.println("Go to 1 unpressed.");
        print();
    }
    public void changeLbuttonTo2State(){
        liftButtonTo2State ^= true;
        if(liftButtonTo2State){
            System.out.println("Go to 2 pressed.");
        }else System.out.println("Go to 2 unpressed.");
        print();
    }
    public boolean getFloorContent(int i){
        return floorContent[i-1];
    }
    public int getLiftPos(){
        return liftPos;
    }
    
}
