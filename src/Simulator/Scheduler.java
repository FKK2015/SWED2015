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
    private int[] Tn_first;
    private int[] Tn_second;
    
    public Scheduler(){
        Tn_first = new int[] {5,1,20};
        Tn_second = new int[] {5,1,20};
    }
    
    public int schedule(int t, State st){
        if(t == Tn_first[1]){
            if(!st.checkFloor1()){
                return 1;
            }
            randInt(Tn_first);
        }
        if(t == Tn_second[1]){
            if(!st.checkFloor2()){
                return 2;
            }
            randInt(Tn_second);
        }//haha
        return 0;
    }
    public void randInt(int[] input) {
        Random rand = new Random();
        int randomNum = rand.nextInt((input[2] - input[0]) + 1) + input[0];
        input[1] = randomNum;
        input[0] += input[1];
        input[2] += input[1];
        System.out.println(input[0] + " " + input[1] + " " + input[2]);
}
    public boolean checkFloor(Floor f){
        return true;
    }
    public Passenger createPassenger(int p){
        return null;
    }
}
