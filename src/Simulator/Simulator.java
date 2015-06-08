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
    
    private Floor firstF;
    private Floor secondF;
    private TimeCounter timer;
    private Scheduler scheduler;
    private State state = new State();
    private LogicController logicC;
    
    public Simulator(){
        firstF = new Floor(1,state);
        secondF = new Floor(2,state);
        timer = new TimeCounter(state);
        scheduler = new Scheduler(state);
        logicC = new LogicController(state);
    }
    
    public void run(){
        while(true){
            timer.count1Sec();
            switch (scheduler.schedule(timer.getTime())){
                case 1:
                    Passenger p = new Passenger(2,1);
                    firstF.addContent(p, logicC);
                    break;
                case 2:
                    p = new Passenger(1,2);
                    secondF.addContent(p, logicC);
                    break;
                case 3:
                    p = new Passenger(2,1);
                    firstF.addContent(p, logicC);
                    p = new Passenger(1,2);
                    secondF.addContent(p,logicC);
                    break;
                default:
                    break;
            }
            logicC.move();
        }
            
    }
    public static void main(String[] args) {
        Simulator sim = new Simulator();
        sim.run();
    }
    
}