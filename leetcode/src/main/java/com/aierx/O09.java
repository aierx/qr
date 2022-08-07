package com.aierx;

import java.util.Stack;

public class O09 {
	Stack<Integer> s1;
	Stack<Integer> s2;
	
	public O09() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	
	public void appendTail(int value) {
		s1.push(value);
	}
	
	public int deleteHead() {
		if (s2.empty()) {
			while (!s1.empty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
	
	public static void main(String[] args) {
        longestCommonPrefix(new String[]{""});
	}
    
    public static String longestCommonPrefix(String[] strs) {
        
        strs = new String[]{"flower", "flow", "flight"};
        int min = Integer.MAX_VALUE;
        if (strs.length==1){
            return strs[0];
        }
        for (String str : strs) {
            min = Math.min(min,str.length());
        }
        StringBuilder res = new StringBuilder();
        loop1:
        for (int i = 0; i < min; i++) {
            Character tmp = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != tmp) {
                    break loop1;
                }
            }
            res.append(tmp);
        }
        return res.toString();
    }
	
	
}
