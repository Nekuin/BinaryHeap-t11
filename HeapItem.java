/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bheap;

/**
 *
 * @author Nekuin
 */
public class HeapItem{
    
    private int data;
    
    public HeapItem(){
        
    }
    
    public HeapItem(int data){
        this.data = data;
    }
    
    public void setData(int data){
        this.data = data;
    }
    
    public int getData(){
        return this.data;
    }

  
    
    @Override
    public String toString(){
        return "[" + this.data + "]";
    }
}
