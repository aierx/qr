package com.aierx.boot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int students = Integer.parseInt(s1[0]);
        int options = Integer.parseInt(s1[1]);
        int[] sore = new int[students];
        if (students==0){
            System.exit(0);
        }
        for (int i = 0; i < (options + 1); i++) {
            String s2 = scanner.nextLine();
            String[] s3 = s2.split(" ");
            if (i==0) {
                for (int i1 = 0; i1 < s3.length; i1++) {
                    sore[i1] = Integer.parseInt(s3[i1]);
                }
            }else {
                if (s3[0].equals("Q")){
                    int begin = Integer.parseInt(s3[1]);
                    int end = Integer.parseInt(s3[2]);
                    if (begin>end){
                        end = Integer.parseInt(s3[1]);
                        begin = Integer.parseInt(s3[2]);
                    }
                    int max = 0;
                    for (int j = begin;j<end&&j<students;j++){
                        if (sore[j]>max){
                            max = sore[j];
                        }
                    }
                    if (begin==end){
                        System.out.println(sore[begin-1]);
                    }else {
                        System.out.println(max);

                    }
                }else {
                    sore[Integer.parseInt(s3[1])] = Integer.parseInt(s3[2]);
                }
            }

        }
    }
}
