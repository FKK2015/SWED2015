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
class Floor {
    private int name;
    private Passenger content;
    private FloorButton fb;
    private State st;
    
    public Floor(int n, State st){
        name = n;
        fb = new FloorButton(n);
        this.st = st;
    }
    public void addContent(Passenger p, LogicController lc){
        content = p;
        st.changeFloorContent(name);
        lc.processButton(this, fb);
    }
    public Passenger getContent(){
        return content;
    }
    public void clearContent(){
        content = null;
        st.changeFloorContent(name);
    }
}
