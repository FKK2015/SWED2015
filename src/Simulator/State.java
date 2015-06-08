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
    private int liftPos = 0;
    private boolean liftButtonTo1State = false;
    private boolean liftButtonTo2State = false;
    private int currentTime = 0;
    
    public void print(){
        
    }
    public void changeDoorState(){
        doorState ^= true;
    }
    public void changeBellState(){
        bellState ^= true;
    }
    public void changeF1buttonState(){
        floor1ButtonState ^= true;
    }
    public void changeF2buttonState(){
        floor2ButtonState ^= true;
    }     
    public void changeFloorContent(int i){
        floorContent[i-1] ^= true;
    } 
    public void changeLiftPos(int p){
        liftPos = p;
    }
    public void changeLiftContent(){
        liftContent ^= true;
    }
    public void changeLbuttonTo1State(){
        liftButtonTo1State ^= true;
    }
    public void changeLbuttonTo2State(){
        liftButtonTo2State ^= true;
    }
    public boolean getFloorContent(int i){
        return floorContent[i-1];//
    }
    
}
