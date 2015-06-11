/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulator;

import java.util.Stack;

/**
 *
 * @author Kris
 */
class LogicController {
    private Stack myStack = new Stack();
    private State st;
    private int timer = 5;
    private int direction = 0;
    private LiftButton goTo1;
    private LiftButton goTo2;
    
    public LogicController(State st){
        this.st = st;
        goTo1 = new LiftButton(1,st);
        goTo2 = new LiftButton(2,st);
    }
    
    public void processButton(Floor f){
        myStack.push(f);
        //System.out.println("Passenger at " + f.getContent().getPosition() + " in call queue.");
        if(timer == 5){
            processStack();
        }
    }
    //public void processButton(LiftButton lb){}
    public void processStack(){
        //System.out.println("Checking if someone is waiting");
        if(!myStack.isEmpty()){
            //System.out.println("Someone is waiting...");
            Floor tempFloor = (Floor) myStack.pop();
            Passenger tempPassanger = tempFloor.getContent();
            if(tempFloor.getContent().getPosition() == st.getLiftPos()){
                //System.out.println("Oh, he is here...");
                st.changeDoorState();
                if(tempFloor.getContent().getDestination() == 1){
                    tempFloor.clearContent();
                    st.changeLiftContent();
                    goTo1.press(goTo1);
                    direction = goTo1.getDestination();
                }else if(tempFloor.getContent().getDestination() == 2){
                    tempFloor.clearContent();
                    st.changeLiftContent();
                    goTo2.press(goTo2);
                    direction = goTo2.getDestination();
                }else{
                    System.out.println("Error!");
                }
                st.changeDoorState();
                tempFloor.getFB().unpress(tempFloor.getFB());
                //move();
            }else{
                //System.out.println("Someone is waiting  but elsewhere...");
                direction = tempFloor.getContent().getPosition();
                //move();
            }
        }else{
            direction = 0;
        }
    }
    public void moveUP(){
        if(timer > 0){
            //System.out.println("Moving up..." + timer);
            timer--;
            st.changeLiftExactLocation(1);
        } else{
            timer = 5;
            goTo2.unpress(goTo2);
            st.changeLiftPos(2);
            st.changeBellState();
            st.changeDoorState();
            st.changeBellState();
            st.changeLiftContent();
            st.changeDoorState();
            processStack();
        }
    }
    public void moveDOWN(){
        if(timer > 0){
            //System.out.println("Moving down..." + timer);
            timer--;
            st.changeLiftExactLocation(-1);
        } else{
            timer = 5;
            goTo1.unpress(goTo1);
            st.changeLiftPos(1);
            st.changeBellState();
            st.changeDoorState();
            st.changeBellState();
            st.changeLiftContent();
            st.changeDoorState();
            processStack();
        }
    }
    public void move(){
        if(goTo1.getState() || goTo2.getState()){
            if(direction == 2){
                moveUP();
            }
            else if(direction == 1){
                moveDOWN();
            }
        }
    }
}
