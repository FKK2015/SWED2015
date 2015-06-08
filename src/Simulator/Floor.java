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
    
    
    public Floor(int n){
        name = n;
    }
    public void addContent(Passenger p, State st){
        content = p;
        st.changeFloorContent(name);
    }
    public Passenger getContent(){
        return content;
    }
}
