/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bheap;

import bheap.HeapItem;

/**
 *
 * @author Nekuin
 */
public class BinaryHeap {
    
    private HeapItem[] arr;
    private int currentSize;
    
    public BinaryHeap(){
        this.arr = new HeapItem[200];
        this.currentSize = 1;
    }
    
    public void insert(int data){
        System.out.println("Inserting: " + data);
        HeapItem item = new HeapItem();
        int itemPos = currentSize;
        arr[currentSize] = item;
        currentSize++;
        //create root if it doesn't exist
        if(itemPos == 1){
            item.setData(data);
        }
        
        if(currentSize > 2){
            int parent = Math.floorDiv(itemPos, 2);
            System.out.println("parent index: " + parent + " data: " + arr[parent].getData());
            if(arr[parent].getData() < data){
                //System.out.println("it fits");
                item.setData(data);
                printItems();
            } else {
                System.out.println("percolate up");
                //percolate up
                percolateUp(data, itemPos);
            }
        }
    }
    
    private void percolateUp(int data, int pos){
        int parent = Math.floorDiv(pos, 2);
        if(parent == 0){
            System.out.println("at the root");
            arr[1] = new HeapItem(data);
            printItems();
            return;
        }
        if(arr[parent].getData() > data && parent != 0){
            int temp = arr[parent].getData();
            System.out.println("temp: " + temp + " to: " + pos);
            arr[parent].setData(0);
            arr[pos].setData(temp);
            percolateUp(data, parent);
        } else {
            System.out.println("it fits now");
            arr[pos] = new HeapItem(data);
        }
    }
    
    
    public HeapItem deleteMin(){
        
        HeapItem min = arr[1];
        System.out.println("deleting: " + min);
        arr[1] = new HeapItem();
        
        percolateDown(1);
        return min;

    }
    
    private void percolateDown(int hole){
        int minChild = findMin(hole);
        if(minChild == -1){
            System.out.println("last one: " + arr[currentSize-1]);
            System.out.println("hole: " + hole);
            arr[hole].setData(arr[currentSize-1].getData());
            arr[currentSize-1] = null;
            currentSize--;
            System.out.println("percolate done");
            return;
        }
        printItems();
        swap(hole, minChild);
        percolateDown(minChild);
    }
    
    /*
    Swap two indexes
    */
    private void swap(int i, int j){
        int temp = arr[i].getData();
        arr[i].setData(arr[j].getData());
        arr[j].setData(temp);
    }
    
    private int findMin(int parent){
        int leftChild = parent * 2;
        int rightChild = parent * 2 + 1;
        if(leftChild > currentSize){
            return -1;
        }
        System.out.println("parent: " + parent + " left: " + leftChild + " right: " + rightChild + " (indexes)");
        
        if(arr[leftChild] != null && arr[rightChild] != null){
            //both found
            HeapItem left = arr[leftChild];
            HeapItem right = arr[rightChild];
            if(left.getData() > right.getData()){
                //arr[rightChild] = last;
                return rightChild;
            } else {
                //arr[leftChild] = last;
                return leftChild;
            }
        } else if(arr[leftChild] != null){
            return leftChild;
        }
        return -1;
    }
    
    public void printItems(){
        for(int i = 1; i < 20; i++){
            if(arr[i] != null){
                System.out.print("" + arr[i].getData() + " ");
            } else {
                System.out.print("n ");
            }
        }
        System.out.println("");
    }
    
    public void clear(){
        this.currentSize = 1;
    }
}
