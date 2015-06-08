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
    private int direction;
    
    public LogicController(State st){
        this.st = st;
    }
    
    public void processButton(Floor f, FloorButton fb){
        myStack.push(f);
        System.out.println("Passenger at " + f.getContent().getPosition() + " in call queue.");
        if(timer == 5){
            processStack();
        }
    }
    public void processButton(LiftButton lb, State st){
        
    }
    public void processStack(){
        System.out.println("Checking if someone is waiting");
        if(!myStack.isEmpty()){
            System.out.println("Someone is waiting...");
            Floor temp = (Floor) myStack.pop();
            if(temp.getContent().getPosition() == st.getLiftPos()){
                System.out.println("Oh, he is here...");
                st.changeDoorState();
                direction = temp.getContent().getDestination();
                temp.clearContent();
                st.changeLiftContent();
                st.changeDoorState();
                move();
            }else{
                System.out.println("Someone is waiting  but elsewhere...");
                direction = temp.getContent().getPosition();
                move();
            }
        }
    }
    public void moveUP(){
        if(timer > 0){
            System.out.println("Moving up..." + timer);
            timer--;
        } else{
            timer = 5;
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
            System.out.println("Moving down..." + timer);
            timer--;
        } else{
            timer = 5;
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
        if(direction == 2){
            moveUP();
        }
        else if(direction == 1){
            moveDOWN();
        }
    }
}
