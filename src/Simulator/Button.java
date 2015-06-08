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
    private boolean state = false;
    private boolean illumination = false;
    
    public void press(){
        illuminationON();
        statePressed();
    }
    public void unpress(){
        illuminationOFF();
        stateUnpressed();
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
