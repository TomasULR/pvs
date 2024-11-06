package oop.basics.generics;

import java.util.Arrays;

public class stacking {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(8);
        stack.push(7);
        stack.push(9);
        stack.pop();
        System.out.println(stack.pop());
        stack.peek();
        System.out.println(stack.pop());

    }
}
class ArrayStack{
    int[] data;
    int freeIndex;

    void expandArray(){
        int[] newOne= new int[data.length*2];
        for (int i = 0; i < data.length; i++) {
            newOne[i] = data[i];
        }
        data = newOne;
    }
    ArrayStack(int capacity){
        data = new int[capacity];
        freeIndex = 0;
    }
    void push(int toAdd){
        if (freeIndex < data.length){
            data[freeIndex] = toAdd;
            freeIndex++;
        }
        else {
            System.out.println("full :(");
        }
    }

    int pop(){
        if (freeIndex > 0){
            int toReturn = data[freeIndex-1];
            freeIndex--;
            return toReturn;
        }
        return -1;
    }

    int peek(){
        if (freeIndex > 0 )
            return data[freeIndex-1];
        return -1;
    }
}
