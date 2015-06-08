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
class FloorButton extends Button{
    private int belongsTOfloor = 0;
    
    public FloorButton(int f){
        belongsTOfloor = f;
    }
    public int getFloor(){
        return belongsTOfloor;
    }
}
