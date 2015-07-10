/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kris
 */
class State {
   
    static File f = new File("statistics.txt");
    static FileWriter fw;
    
    private int usersF1 = 0;
    private int usersF2 = 0;
    private double avg_time = 0.;
    private double wait_time = 0;
    private int idle_time = 0;
    private boolean doorState = false;
    private boolean bellState = false;
    private boolean floor1ButtonState = false;
    private boolean floor2ButtonState = false;
    private boolean[] floorContent = new boolean[]{false,false};
    private boolean liftContent = false;
    private int liftPos = 1;
    private boolean liftButtonTo1State = false;
    private boolean liftButtonTo2State = false;
    private int liftExactLocation = 0;
    private int time = 0;
    private Passenger pInLift;
    
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
            {floorGround,"=","=","=======","=","=|"+String.valueOf(time)+"|\n"},
            {"users on F2: ",String.valueOf(usersF2)," | ","avg waiting time: ",String.valueOf(avg_time),"\n"},
            {"users on F1: ",String.valueOf(usersF1)," | ","idle time: ",String.valueOf(idle_time),"\n"}
                                };
        picture[5-liftExactLocation][1] = leftDoor;
        picture[5-liftExactLocation][2] = bell;
        picture[5-liftExactLocation][3] = liftC;
        picture[5-liftExactLocation][4] = liftBut;
        picture[5-liftExactLocation][5] = rightDoor;
        for (String[] picture1 : picture) {
            System.out.print(picture1[0]);
            for (int j = 1; j < picture1.length; j++) {//length = 8
                System.out.print(picture1[j]);
            }
        }
        System.out.println();
        System.out.println("/////////////////////////////////");
        System.out.println();
        try {
            TimeUnit.MILLISECONDS.sleep(250);
        } catch (InterruptedException ex) {
            Logger.getLogger(State.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(State.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    public void changeLiftExactLocation(int i){
        liftExactLocation += i;
        print();
        //System.out.println("Lift at: "+liftExactLocation);
    }
    public void openDoor(){
        doorState = true;
        //System.out.println("Doors open.");
        if(liftContent){
            liftC = passanger;
        }else{
            liftC = emptySpaceLift;
        }
        
        print();
    }
    public void closeDoor(){
        doorState = false;
        //System.out.println("Doors close.");
        liftC =  closedDoors;
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
    public void F1buttonON(){
        floor1ButtonState = true;
        //System.out.println("Floor 1 button is pressed.");
        F1B = "FB1";
        usersF1++;
        print();
    }
    public void F1buttonOFF(){
        floor1ButtonState = false;
        //System.out.println("Floor 1 button is unpressed.");
        F1B = "   ";
        print();
    }
    public void F2buttonON(){
        floor2ButtonState = true;
        //System.out.println("Floor 2 button is pressed.");
        F2B = "FB2";
        usersF2++;
        print();
    } 
    public void F2buttonOFF(){
        floor2ButtonState = false;
        //System.out.println("Floor 2 button is unpressed.");
        F2B = "   ";
        print();
    }
    public void addFloorContent(int i){
        floorContent[i-1] = true;
        //System.out.println("Floor " + i + " has a passenger.");
        if(i == 1){
            F1C = passanger;
        }else{
            F2C = passanger;
        }
        print();
    }
    public void removeFloorContent(int i){
        floorContent[i-1] = false;
        //System.out.println("Floor " + i + " is empty.");
        if(i == 1){
            F1C = emptyFloor;
        }else{
            F2C = emptyFloor;
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
    public void addLiftContent(Passenger p){
        liftContent = true;
        pInLift = p;
        //System.out.println("Lift full.");
        liftC = passanger;
        print();
    }
    public void removeLiftContent(){
        liftContent = false;
        //System.out.println("haha");
        pInLift.setStat(time);
        wait_time += (pInLift.getStat(2)-pInLift.getStat(1));
        avg_time = wait_time / pInLift.getStat(0);
        try{
            fw = new FileWriter(f,true);
            fw.write(pInLift.getStats());
            fw.write(System.getProperty("line.separator"));
            fw.close();
        }catch(IOException e){
            System.out.println(""+e.toString());
	}
        //System.out.println("Lift empty.");
        liftC = emptySpaceLift;
        print();
    }
    public void LBto1ON(){
        liftButtonTo1State = true;
        //System.out.println("Go to 1 pressed.");
        liftBut = "V";
        print();
    }
    public void LBto1OFF(){
        liftButtonTo1State = false;
        //System.out.println("Go to 1 unpressed.");
        liftBut = " ";
        print();
    }
    public void LBto2ON(){
        liftButtonTo2State = true;
        //System.out.println("Go to 2 pressed.");
        liftBut = "A";
        print();
    }
    public void LBto2OFF(){
        liftButtonTo2State = false;
        //System.out.println("Go to 2 unpressed.");
        liftBut = " ";
        print();
    }
    public boolean getFloorContent(int i){
        return floorContent[i-1];
    }
    public int getLiftPos(){
        return liftPos;
    }
    public void setTime(int t){
        time = t;
        print();
    }
    public boolean getDoorState(){
        return doorState;
    }
    public boolean getLiftContent(){
        return liftContent;
    }
    public void closeWriter() throws IOException{
        fw.close();
    }   
    public void isIdle(){
        if (!(liftButtonTo1State || liftButtonTo2State || floor1ButtonState || floor2ButtonState)){
            idle_time++;
        }
    }
}
