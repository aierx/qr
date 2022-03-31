package com.aierx;


import java.util.Date;

public class Size {
    public static void main(String[] args) {
        long l = ObjectSizeFetcher.sizeOf(new Date());
        System.out.println(l);
    }
}
