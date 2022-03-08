package com.aierx;

import org.junit.Test;

import java.util.HashMap;

public class AierxSolution {

    @Test
    public void Test() {
//        int[] arr = {1,2,4,1,7,8,3};
        int[] arr = {4, 1, 1, 9, 1};
        int i = dp_opt(arr);
        System.out.println(i);
    }

    /**
     * 选最大不连续字串
     * 测试数组 {1，2，3，1，7，8，3} 递归
     * 无脑递归
     * @param arr
     * @param i
     * @return
     */
    public int rec_opt(int[] arr, int i) {
        if (i == 0) return arr[0];
        if (i == 1) return Math.max(arr[0], arr[1]);
        return Math.max(rec_opt(arr, i - 2) + arr[i],
                rec_opt(arr, i - 1));
    }

    public int dp_opt(int[] arr) {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[1], arr[0]);
        for (int j = 2; j < arr.length; j++) {
            opt[j] = Math.max(opt[j - 2] + arr[j], opt[j - 1]);
        }
        return opt[arr.length - 1];
    }

    //    ---------------------------------------
    @Test
    public void test2() {
        int[] arr = {3, 34, 4, 12, 5, 2};
        boolean b = dp_subset(arr, 9 );
        System.out.println(b);
    }

    /**
     * 指定数组字串是否有目标和
     * 无脑递归
     * @param arr
     * @param i
     * @param s
     * @return
     */
    public boolean rec_subset(int[] arr, int i, int s) {
        if (s == 0) return true;
        if (i == 0) return arr[i] == s;
        if (arr[i] > s) return rec_subset(arr, i - 1, s);
        return rec_subset(arr, i - 1, s - arr[i]) || rec_subset(arr, i - 1, s);
    }

    public boolean dp_subset(int[] arr,int s){
        boolean[][] dp = new boolean[arr.length][s+1];
        for (int i = 0;i<dp.length;i++)dp[i][0]=true;
        dp[0][arr[0]]=true;
        for (int i =1;i<dp.length;i++){
            for (int j =1 ;j<dp[0].length;j++){
                if (arr[i]>j)dp[i][j]=dp[i-1][j];
                else dp[i][j] = dp[i-1][j-arr[i]]||dp[i-1][j];
            }
        }
        return dp[arr.length-1][s];
    }

//    -----------------3---------------------

    @Test
    public void test3(){
        int i = dp_translateNum(12258);
        System.out.println(i);
    }

    /**
     * 把数字翻译成字符串
     * 无脑递归
     * @param num
     * @return
     */
    int translateNum(int num){
        if(num<10)return 1;
        if (num%100<26&&num%100>9)return translateNum(num/10)+translateNum(num/100);
        else return translateNum(num/10);
    }

    int dp_translateNum(int num){
        String str = String.valueOf(num);
        int p =0;
        int q = 0;
        int r = 1;
        for(int i=0;i<str.length();i++){
            p=q;
            q=r;
            r = 0;
            r+=q;
            if (i == 0) {
                continue;
            }
            String pre = str.substring(i - 1, i + 1);
            if (pre.compareTo("25")<=0&&pre.compareTo("10")>=0)r+=p;
        }
        return r;

    }

    /**
     * 最长不连续字串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;int temp =0;
        for (int i = 0;i<s.length();i++){
            
        }
        return 0;
    }

}
