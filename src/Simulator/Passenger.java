/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulator;

/**
 *
 * @author K&K
 */
class Passenger {
    private int destination;
    private int position;
    
    public Passenger(int d, int p){
        destination = d;
        position = p;
    }
    public void setPosition(int p){
        position = p;
    }
    public void setDestination(int d){
        destination = d;
    }
    public int getPosition(){
        return position;
    }
    public int getDestination(){
        return destination;
    }
}
