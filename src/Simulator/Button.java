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
    
    public boolean getState(){
        return state;
    }
    public void press(FloorButton fb){
        illuminationON();
        statePressed();
        if(fb.getFloor() == 1){
            st.F1buttonON();
        }else if(fb.getFloor() == 2){
            st.F2buttonON();
        }else{
            System.out.println("Error!");
        }
    }
    public void press(LiftButton lb){
        illuminationON();
        statePressed();
        if(lb.getDestination() == 1){
            st.LBto1ON();
        }else if(lb.getDestination() == 2){
            st.LBto2ON();
        }else{
            System.out.println("Error!");
        }
    }
    public void unpress(FloorButton fb){
        illuminationOFF();
        stateUnpressed();
        if(fb.getFloor() == 1){
            st.F1buttonOFF();
        }else if(fb.getFloor() == 2){
            st.F2buttonOFF();
        }else{
            System.out.println("Error!");
        }
    }
    public void unpress(LiftButton lb){
        illuminationOFF();
        stateUnpressed();
        if(lb.getDestination() == 1){
            st.LBto1OFF();
        }else if(lb.getDestination() == 2){
            st.LBto2OFF();
        }else{
            System.out.println("Error!");
        }
    }
    public void illuminationON(){
        illumination = true;
    }
    public void illuminationOFF(){
        illumination = false;
    }
    public void statePressed(){
        state = true;
    }
    public void stateUnpressed(){
        state = false;
    }
}
