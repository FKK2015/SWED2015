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
public class Simulator {
    
    private Floor firstF = new Floor(1);
    private Floor secondF = new Floor(2);
    private TimeCounter timer = new TimeCounter();
    private Scheduler scheduler = new Scheduler();
    private State state = new State();
    
    public void run(){
        while(true){
            timer.count1Sec();
            if(scheduler.schedule(timer.getTime(), state) == 1){
                //firstF.addContent();
            }
            else if ((scheduler.schedule(timer.getTime(), state) == 2)){
                //secondF.addContent();
            }
        }
    }
    public static void main(String[] args) {
        Simulator sim = new Simulator();
        sim.run();
    }
    
}