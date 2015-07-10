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
class Passenger {
    private int destination;
    private int position;
    private int[] stats;
    private static int num;
    
    public Passenger(int d, int p, int s){
        destination = d;
        position = p;
        stats = new int[3];
        num++;
        stats[0] = num;
        stats[1] = s;
    }
    public void setPosition(int p){
        position = p;
    }
    public void setDestination(int d){
        destination = d;
    }
    public int getPosition(){
        return position;
    }
    public int getDestination(){
        return destination;
    }
    public void setStat(int stat){
        stats[2] = stat;
    }
    public String getStats(){
        return (String.valueOf(stats[0])+' '+String.valueOf(stats[1])+' '+String.valueOf(stats[2]));
    }
    public int getStat(int stat){
        if(stat == 0){
            return stats[0];
        }
        else if(stat == 1){
            return stats[1];
        }
        else{
            return stats[2];
        }
    }
}
