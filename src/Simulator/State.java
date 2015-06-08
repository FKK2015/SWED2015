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
    private boolean floor1Content = false;
    private boolean floor2Content = false;
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
    public      
}
