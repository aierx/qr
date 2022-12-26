package com.aierx;

/**
 * @author leiwenyong
 * @since 2022-09-10
 */
public class kmp {
	
	
	public static void main(String[] args) {
		String s = "ababcabcacbab";
		String t = "abc";
		System.out.println(Index(s, t));
	}
	
	static int  Index(String S, String T) {
		int i = 0;
		int j = 0;
		while (i < S.length() && j < T.length()) {
			if (S.charAt(i) == T.charAt(j)) {
				++j;
				++i;
			} else {
				i = i - j+1;
				j = 0;
			}
		}
		
		if (j > T.length()-1) return i - T.length();
		else return 0;
	}
	
	
}
