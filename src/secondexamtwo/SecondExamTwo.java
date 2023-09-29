/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondexamtwo;

import java.util.Scanner;


public class SecondExamTwo {

     private class DoubleNode{
        DoubleNode next;
        String data;
        DoubleNode prev;
}
    
    private DoubleNode head;
    private int size;
    
    private DoubleNode createNewNode(String index) throws Exception{
        DoubleNode doubleNewNode = new DoubleNode();
        if (doubleNewNode == null){
            throw new Exception("Memory not allocated");
        }else{
            doubleNewNode.data = index;
            doubleNewNode.prev = null;
            doubleNewNode.next = null;
            return doubleNewNode;
        }
    }
    
    public void insertion(String index, int position) throws Exception{
        if (position < 0 || position > size){
            throw new Exception("Invalid Position");
            
        }if (position == 0){
            inserAtBeginning(index);
        }else if (position == size){
            insertAtEnding(index);
        }else {
            DoubleNode node = createNewNode(index);
            DoubleNode prevNode = getNodeAt(position - 1);
            DoubleNode nextNode = prevNode.next;
            
            prevNode.next = node;
            node.prev = prevNode;
            node.next = nextNode;
            nextNode.prev = node;
            
            size++;
        }
        
    }
    
    public void inserAtBeginning(String index) throws Exception{
        DoubleNode doubleNewNode = createNewNode(index);
        DoubleNode temporary = new DoubleNode();
        
        if (head == null){
            head = doubleNewNode;
        }else{
            temporary = head;
            head = doubleNewNode;
            head.next = temporary;
        }
        size++;
    }

    public void insertAtEnding(String index) throws Exception{
        DoubleNode doubleNode = createNewNode(index);
        DoubleNode temporary = new DoubleNode();
        
        temporary = head;
        
        while (temporary.next != null){
            temporary = temporary.next;
        }
        temporary.next = doubleNode;
        doubleNode.prev = temporary;
        size++;
    }
    
    public void deletion(int position) throws Exception{
        if (position < 0 || position == size){
            throw new Exception("Invalid Index");
        }
        if(size == 0){
            throw new Exception("List is Empty");
        }
        if (position == 0){
            deleteBeginning();
        }else if (position == size -1){
            deleteEnding(position);
        }else{
            DoubleNode prevNode = getNodeAt(position - 1);
            DoubleNode nextNode = getNodeAt(position + 1);
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
    }
    
    public void deleteBeginning() throws Exception{
        head = head.next;
        head.prev = null;
    }
    public void deleteEnding(int position) throws Exception{
        DoubleNode prev = getNodeAt(position - 1);
        prev.next = null;
    }
    
    public DoubleNode getNodeAt(int index)throws Exception{
        if (size == 0){
            throw new Exception ("PICK SOME THING FIRST");
        }
        else if (index < 0 || index >= size){
            throw new Exception("Invalid Product");
        }
        
        DoubleNode temporary = head;
        
        for (int i = 0; i <index; i++){
            temporary = temporary.next;
        }
        return temporary;
    }
    
    private void display()throws Exception{
        if (size == 0){
            throw new Exception("WALANG LAMAN!!!");
        }else{
            DoubleNode temporary = head;
            while (temporary != null){
                System.out.println(temporary.data +"->");
                temporary = temporary.next;
            }
            System.out.println("Null \n");
        }
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        SecondExamTwo list = new SecondExamTwo();
        boolean start = true;
        
        while (start){
            System.out.println("Ms. Inday Mapanira Sari-Sari Store");
            System.out.println("Procut List : Fita, Pride Powder, Canola oil, Nescafe Black Coffe, Ariel Powder, Rebisco,"
                    + " Steelwool, Head and Shoulders, Nova, Tanduay, Bearbrand, Nature Spring Mineral Water 8oz., Coke 1ltr.,"
                    + " Royal 1ltr., and Sugar");
            System.out.println("1. Purches: ");
            
            
            int choice = scn.nextInt();
            String index;
            int position;
            
            switch (choice){
                case 1:
                    
            }
            
        }
        
    }
    
}
