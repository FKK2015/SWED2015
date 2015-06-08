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
class LiftButton extends Button{
    private int destination;
    
    public void setDestination(int d){
        destination = d;
    }
    public int getDestination(){
        return destination;
    }
}
