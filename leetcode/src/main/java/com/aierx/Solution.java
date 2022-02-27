package com.aierx;

import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (target > matrix[i][j]) j++;
            else if (target < matrix[i][j]) i--;
            else return true;
        }
        return false;
    }

    public String replaceSpace(String s,int n) {
        return s.substring(n)+s.substring(0,n);


    }

}