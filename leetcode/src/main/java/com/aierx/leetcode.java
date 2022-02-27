package com.aierx;

import java.io.File;
import java.util.*;

public class leetcode {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        HashSet<String> sets = new HashMap<String,String>();
        List<String> list = new ArrayList<>();

        while(sc.hasNext()){
            String s = sc.nextLine();
            sets.add(s);
        }
        for (String s: sets){
            if (list.size()==8)break;
            String[] split = s.split("\\\\");
            String str = split [split.length-1];
            String[] s1 = str.split(" ");
            String[] split1 = s1[0].split("\\.");
            String c1 = split1[0].length()>16?split1[0].substring(split1[0].length()-16):split1[0];
            String c2 = "."+split1[1];
            String c3 =s1[1];
            String c4 =String.valueOf( list.size()+1);
            list.add(c1+c2+" "+ c3 +" "+ c4);
        }
        for(String re:list){
            System.out.println(re);
        }
    }


}
