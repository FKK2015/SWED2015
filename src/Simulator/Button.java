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
class Button {
    protected boolean state = false;
    protected boolean illumination = false;
    protected State st;
    
    public void press(FloorButton fb){
        illuminationON();
        statePressed();
        if(fb.getFloor() == 1){
            st.changeF1buttonState();
        }else if(fb.getFloor() == 2){
            st.changeF2buttonState();
        }else{
            System.out.println("Error!");
        }
    }
    public void press(LiftButton lb){
        illuminationON();
        statePressed();
        if(lb.getDestination() == 1){
            st.changeLbuttonTo1State();
        }else if(lb.getDestination() == 2){
            st.changeLbuttonTo2State();
        }else{
            System.out.println("Error!");
        }
    }
    public void unpress(FloorButton fb){
        illuminationOFF();
        stateUnpressed();
        if(fb.getFloor() == 1){
            st.changeF1buttonState();
        }else if(fb.getFloor() == 2){
            st.changeF2buttonState();
        }else{
            System.out.println("Error!");
        }
    }
    public void unpress(LiftButton lb){
        illuminationOFF();
        stateUnpressed();
        if(lb.getDestination() == 1){
            st.changeLbuttonTo1State();
        }else if(lb.getDestination() == 2){
            st.changeLbuttonTo2State();
        }else{
            System.out.println("Error!");
        }
    }
    public void illuminationON(){
        illumination ^= true;
    }
    public void illuminationOFF(){
        illumination ^= false;
    }
    public void statePressed(){
        state ^= true;
    }
    public void stateUnpressed(){
        state ^= false;
    }
}
