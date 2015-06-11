/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulator;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private int liftExactLocation = 0;
    
    private String emptyFloor = "       ";
    private String F1C = "       ";
    private String F2C = "       ";
    private String floorGround = "================";
    private String emptySpaceBetweenFloors = "                ";
    private String emptySpaceLiftPos = "          ";
    private String leftDoor = "[";
    private String rightDoor = "]\n";
    private String liftBut = " ";
    private String liftPositionDisplay = "1|";
    private String F1B = "   ";
    private String F2B = "   ";
    private String passanger = "<(^.^)>";
    private String closedDoors = "|||||||";
    private String liftC = "|||||||";
    private String emptySpaceLift = "       ";
    private String bell = " ";
    
    public void print(){
        String[][] picture = {
            {"  "+F2C+"  "+liftPositionDisplay+F2B," "," ",emptySpaceLift," "," \n"},
            {floorGround,"  "," ",emptySpaceLift," "," \n"},
            {emptySpaceBetweenFloors," "," ",emptySpaceLift," "," \n"},
            {emptySpaceBetweenFloors," "," ",emptySpaceLift," "," \n"},
            {emptySpaceBetweenFloors," "," ",emptySpaceLift," "," \n"},
            {"  "+F1C+"  "+liftPositionDisplay+F1B," "," ",emptySpaceLift," "," \n"},
            {floorGround,"=","=","=======","=","=\n"},
                                };
        picture[5-liftExactLocation][1] = leftDoor;
        picture[5-liftExactLocation][2] = bell;
        picture[5-liftExactLocation][3] = liftC;
        picture[5-liftExactLocation][4] = liftBut;
        picture[5-liftExactLocation][5] = rightDoor;
        for (String[] picture1 : picture) {
            System.out.print(picture1[0]);
            for (int j = 1; j < picture1.length; j++) {
                System.out.print(picture1[j]);
            }
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(State.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println();
        System.out.println("/////////////////////////////////");
        System.out.println();
    }
    public void changeLiftExactLocation(int i){
        liftExactLocation += i;
        print();
        //System.out.println("Lift at: "+liftExactLocation);
    }
    public void changeDoorState(){
        doorState ^= true;
        if(doorState){
            //System.out.println("Doors open.");
            if(liftContent){
                liftC = passanger;
            }else{
                liftC = emptySpaceLift;
            }
        }else{
            //System.out.println("Doors close.");
            liftC =  closedDoors;
        }
        print();
    }
    public void changeBellState(){
        bellState ^= true;
        if(bellState){
            //System.out.println("Ring, ring, ring...");
            bell = "B";
        }else{
            //System.out.println("No more ring.");
            bell = " ";
        }
        print();
    }
    public void changeF1buttonState(){
        floor1ButtonState ^= true;
        if(floor1ButtonState){
            //System.out.println("Floor 1 button is pressed.");
            F1B = "FB1";
        }else{
            //System.out.println("Floor 1 button is unpressed.");
            F1B = "   ";
        }
        print();
    }
    public void changeF2buttonState(){
        floor2ButtonState ^= true;
        if(floor2ButtonState){
            //System.out.println("Floor 2 button is pressed.");
            F2B = "FB2";
        }else{
            //System.out.println("Floor 2 button is unpressed.");
            F2B = "   ";
        }
        print();
    }     
    public void changeFloorContent(int i){
        floorContent[i-1] ^= true;
        if(floorContent[i-1]){
            //System.out.println("Floor " + i + " has a passenger.");
            if(i == 1){
                F1C = passanger;
            }else{
                F2C = passanger;
            }
        }else{
            //System.out.println("Floor " + i + " is empty.");
            if(i == 1){
                F1C = emptyFloor;
            }else{
                F2C = emptyFloor;
            }
        }
        print();
    } 
    public void changeLiftPos(int p){
        liftPos = p;
        if(liftPos == 1){
            //System.out.println("Lift at floor " + p);
            liftPositionDisplay = "1|";
        }else{
            //System.out.println("Lift at floor " + p);
            liftPositionDisplay = "2|";
        }
        print();
    }
    public void changeLiftContent(){
        liftContent ^= true;
        if(liftContent){
            //System.out.println("Lift full.");
            liftC = passanger;
        }else{
            //System.out.println("Lift empty.");
            liftC = emptySpaceLift;
        }
        print();
    }
    public void changeLbuttonTo1State(){
        liftButtonTo1State ^= true;
        if(liftButtonTo1State){
            //System.out.println("Go to 1 pressed.");
            liftBut = "V";
        }else{
            //System.out.println("Go to 1 unpressed.");
            liftBut = " ";
        }
        print();
    }
    public void changeLbuttonTo2State(){
        liftButtonTo2State ^= true;
        if(liftButtonTo2State){
            //System.out.println("Go to 2 pressed.");
            liftBut = "A";
        }else{
            //System.out.println("Go to 2 unpressed.");
            liftBut = " ";
        }
        print();
    }
    public boolean getFloorContent(int i){
        return floorContent[i-1];
    }
    public int getLiftPos(){
        return liftPos;
    }
    
}
