/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulator;

import java.util.Random;

/**
 *
 * @author Kris
 */
class Scheduler {
    private int T1 = 0;
    private int T2 = 0;
    private State st;
    
    public Scheduler(State st){
        T1 = randInt(T1);
        T2 = randInt(T2);
        this.st = st;
    }
    
    public int schedule(int t){
        int temp = 0;
        if(t == T1){
            if(!st.getFloorContent(1)){
                temp++;
            }
            T1 = randInt(T1);
        }
        if(t == T2){
            if(!st.getFloorContent(2)){
                temp += 2;
            }
            T2 = randInt(T2);
        }
        return temp;
    }
    private int randInt(int i) {
        Random rand = new Random();
        int randomNum = rand.nextInt((i+20) - (i+5) + 1) + (i+5);
        System.out.print((i+5)+" | ");
        System.out.print(randomNum+" | ");
        System.out.println((i+20));
        return randomNum;
}
    public boolean checkFloor(Floor f){
        return true;
    }
}
