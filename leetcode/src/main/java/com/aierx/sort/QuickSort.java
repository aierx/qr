package com.aierx.sort;

/**
 * @author leiwenyong
 * @since 2022/3/20
 */
public class QuickSort {



    public static int[] kuaipai(int[] arr ,int low ,int high){

        if(low>=high) {
            return null;
        }

        int pivot = partition(arr,low,high);

        kuaipai(arr,low,pivot-1);
        kuaipai(arr,pivot+1,high);
        return arr;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];

        while (low<high){
            while (low<high&&arr[high]>=pivot) {
                --high;
            }
            arr[low]=arr[high];
            while (low<high&&arr[low]<=pivot) {
                ++low;
            }
            arr[high] = arr[low];
        }

        arr[low] = pivot;
        return low;

    }


}
