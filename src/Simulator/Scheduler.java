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
    private State st;
    
    public Scheduler(State st){
        Tn_first = new int[] {5,0,20};
        Tn_second = new int[] {5,0,20};
        randInt(Tn_first);
        randInt(Tn_second);
        this.st = st;
    }
    
    public int schedule(int t){
        int temp = 0;
        if(t == Tn_first[1]){
            if(!st.getFloorContent(1)){
                temp++;
            }
            randInt(Tn_first);
        }
        if(t == Tn_second[1]){
            if(!st.getFloorContent(2)){
                temp += 2;
            }
            randInt(Tn_second);
        }
        return temp;
    }
    private void randInt(int[] input) {
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
}
