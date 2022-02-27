package com.aierx;

import java.util.Stack;

public class O09 {
    Stack<Integer> s1;
    Stack<Integer> s2 ;
    public O09(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.empty()){
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
