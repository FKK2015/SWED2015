/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulator;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Kris
 */
class TimeCounter {
    private int currentTime = 0;
    private State st;
    
    public TimeCounter(State st){
        this.st = st;
    }
    
    public void count1Sec(){
        try {
            st.isIdle();
            TimeUnit.SECONDS.sleep(1);
            currentTime++;
            st.setTime(currentTime);
        } catch (InterruptedException e) {
            //Handle exception
        }
    }
    
    public int getTime(){
        return currentTime;
    }
}
