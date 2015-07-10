/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author K&K
 */
public class Simulator {
    
    private Floor firstF;
    private Floor secondF;
    private TimeCounter timer;
    private Scheduler scheduler;
    //PrintWriter outfile;
    private State state = new State();
    private LogicController logicC;
    private Passenger tmp1;
    private Passenger tmp2;
    
    public Simulator(){
        firstF = new Floor(1,state);
        secondF = new Floor(2,state);
        timer = new TimeCounter(state);
        scheduler = new Scheduler(state);
        logicC = new LogicController(state);
    }
    
    public void run() throws IOException{
        while(true){
            timer.count1Sec();
            logicC.move();
            switch (scheduler.schedule(timer.getTime())){
                case 1:
                    tmp1 = new Passenger(2,1,timer.getTime());
                    firstF.addContent(tmp1, logicC);
                    break;
                case 2:
                    tmp2 = new Passenger(1,2,timer.getTime());
                    secondF.addContent(tmp2, logicC);
                    break;
                case 3:
                    tmp1 = new Passenger(2,1,timer.getTime());
                    firstF.addContent(tmp1, logicC);
                    tmp2 = new Passenger(1,2,timer.getTime());
                    secondF.addContent(tmp2, logicC);
                    break;
                default:
                    break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Simulator sim = new Simulator();
        sim.run();
    }
    
}