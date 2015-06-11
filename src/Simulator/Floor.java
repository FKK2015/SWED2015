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
        fb = new FloorButton(n,st);
        this.st = st;
    }
    public void addContent(Passenger p, LogicController lc){
        content = p;
        st.addFloorContent(name);
        fb.press(fb);
        lc.processButton(this);
    }
    public Passenger getContent(){
        return content;
    }
    public void clearContent(){
        content = null;
        st.removeFloorContent(name);
    }
    public FloorButton getFB(){
        return fb;
    }
    public int getName(){
        return name;
    }
}
