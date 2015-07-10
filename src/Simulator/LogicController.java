/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulator;

/**
 *
 * @author Kris
 */
class LogicController {
    //private Stack myStack = new Stack();
    //private List<Floor> calls = new ArrayList<>();
    private Floor[] calls = new Floor[]{null,null,null};
    private State st;
    private int timer = 5;
    private int direction = 0;
    private LiftButton goTo1;
    private LiftButton goTo2;
    private Floor tempFloor;
    
    public LogicController(State st){
        this.st = st;
        goTo1 = new LiftButton(1,st);
        goTo2 = new LiftButton(2,st);
    }
    
    public void processButton(Floor f){
        calls[f.getName()] = f;
        //calls.add(f);
        //System.out.println("Passenger at " + f.getContent().getPosition() + " in call queue.");
        if(timer == 5 && direction == 0){
            processCalls();
        }
    }
    //public void processButton(LiftButton lb){}
    public void processCalls(){
        //System.out.println("Checking if someone is waiting");
        if(calls[st.getLiftPos()] != null){
            tempFloor = calls[st.getLiftPos()];
            calls[st.getLiftPos()] = null;
            if(!st.getDoorState()){
                    st.openDoor();
                }
            if(tempFloor.getContent().getDestination() == 1){
                    st.addLiftContent(tempFloor.getContent());
                    tempFloor.clearContent();
                    goTo1.press(goTo1);
                    direction = goTo1.getDestination();
            }else if(tempFloor.getContent().getDestination() == 2){
                    st.addLiftContent(tempFloor.getContent());
                                        tempFloor.clearContent();
                    goTo2.press(goTo2);
                    direction = goTo2.getDestination();
            }else{
                    System.out.println("Error!");
            }
            st.closeDoor();
            tempFloor.getFB().unpress(tempFloor.getFB());
        }
        else if(calls[st.getLiftPos()] == null){
            for(Floor temp : calls){
                if(temp != null){
                    tempFloor = temp;
                    direction = tempFloor.getContent().getPosition();
                    st.closeDoor();
                    return;
                }
            }
            direction = 0;
            st.closeDoor();
        }
        else{
            System.out.println("Error!");
        }
    }
    public void moveUP(){
        if(timer > 0){
            //System.out.println("Moving up..." + timer);
            timer--;
            st.changeLiftExactLocation(1);
        } else{
            timer = 5;
            direction = 0;
            goTo2.unpress(goTo2);
            st.changeLiftPos(2);
            st.changeBellState();
            st.openDoor();
            st.changeBellState();
            if(st.getLiftContent()){
                st.removeLiftContent();
            }
            processCalls();
        }
    }
    public void moveDOWN(){
        if(timer > 0){
            //System.out.println("Moving down..." + timer);
            timer--;
            st.changeLiftExactLocation(-1);
        } else{
            timer = 5;
            direction = 0;
            goTo1.unpress(goTo1);
            st.changeLiftPos(1);
            st.changeBellState();
            st.openDoor();
            st.changeBellState();
            if(st.getLiftContent()){
                st.removeLiftContent();
            }
            processCalls();
        }
    }
    public void move(){
        //if(){
            if(direction == 2){
                moveUP();
            }
            else if(direction == 1){
                moveDOWN();
            }
       // }
    }
    public int getDirection(){
        return direction;
    }
}
