package com.aierx;


public class Sort {
    // 快速排序
    void quickSort(int[] arr,int low,int high){
        if(low>=high){
            return ;
        }
        int pivot = partition(arr,low,high);
        quickSort(arr,low,pivot-1);
        quickSort(arr,pivot+1,high);
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];
        }
        arr[low]=pivot;
        return low;
    }

    // 插入
    public void charu(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j>0&&arr[j]<arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }

    // 冒泡

    public void  maopao(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // 选择
    public void xuanze(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }



}
