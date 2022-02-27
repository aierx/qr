package com.aierx;

class MinStack {
    int[] s1 = new int[10000];
    int[] s2 = new int[10000];

    int a = 0;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        s1[a] = x;
        if (a>0){
            s2[a] = (s2[a-1] < x) ? s2[a-1] : x;
        }else {
            s2[a] = x;
        }
        a++;
    }

    public void pop() {
        a--;
    }

    public int top() {
        return s1[a - 1];
    }

    public int min() {
        return s2[a - 1];
    }
}