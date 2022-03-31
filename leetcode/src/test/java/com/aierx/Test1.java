package com.aierx;

import com.aierx.sort.QuickSort;
import org.junit.Before;
import org.junit.Test;

/**
 * @author leiwenyong
 * @since 2022/3/20
 */
public class Test1 {
    int[] arr;


    @Before
    public void before(){

        arr = new int[]{4, 5, 6, 3, 7, 9, 6, 8, 2, 9, 43, 634, 234, 655, 234};
    }

    @Test
    public void testQuickSort(){
        int[] kuaipai = QuickSort.kuaipai(arr, 0, arr.length-1);
        for (int i : kuaipai) {
            System.out.println(i);
        }
    }
}
