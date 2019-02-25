/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bheap;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Nekuin
 */
public class BHeap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();
        
        Scanner scanner = new Scanner(System.in);
        while(true){
            printMenu();
            String input = scanner.nextLine();
            int choice = Integer.parseInt(input);
            switch(choice){
                case 1:
                    input = scanner.nextLine();
                    int i = Integer.parseInt(input);
                    heap.insert(i);
                    break;
                case 2:
                    HeapItem item = heap.deleteMin();
                    System.out.println("Removed: " + item);
                    heap.printItems();
                    break;
                case 3:
                    System.out.println("---------");
                    heap.printItems();
                    System.out.println("---------");
                    break;
                case 4:
                    System.exit(0);
                    break;
                case 5:
                    for(int j = 10; j > 1; j--){
                        heap.insert(j);
                    }
                    break;
                case 6:
                    for(int j = 1; j < 10; j++){
                        heap.insert(j);
                    }
                    break;
                case 7:
                    heap.clear();
                    break;
            }
        }
    }
    
    static void printMenu(){
        System.out.println("\t1. Add a number");
        System.out.println("\t2. Remove min");
        System.out.println("\t3. Print heap");
        System.out.println("\t4. Exit");
        System.out.println("\t5. Insert 10...1");
        System.out.println("\t6. Insert 1...10");
        System.out.println("\t7. Clear");
    }
    
}
