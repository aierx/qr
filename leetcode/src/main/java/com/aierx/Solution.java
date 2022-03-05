package com.aierx;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j < matrix[0].length) {
            if (target == matrix[i][j]) return true;
            if (target > matrix[i][j]) j++;
            else i--;
        }
        return false;

    }


    public int[] levelOrder(TreeNode root) {
        TreeNode[] treeNodes = new TreeNode[1000];
        int in = 0;
        int out = 0;
        List<Integer> list = new ArrayList<>();
        treeNodes[in++] = root;
        while (in>out){
            if (treeNodes[out]!=null){
                list.add(treeNodes[out].val);
                System.out.println(treeNodes[out].val);
                if (treeNodes[out].left!=null)treeNodes[in++]=treeNodes[out].left;
                if (treeNodes[out].right!=null)treeNodes[in++]=treeNodes[out].right;
            }
            out++;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null&&B!=null)&&
                (recur(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if (B==null)return true;
        if(A==null||B.val!=A.val)return false;
        return recur(A.left,B.left)&&recur(A.right,B.right);
    }


    public TreeNode mirrorTree(TreeNode root) {
        if (root!=null) {
            mirrorTree (root.left);
            mirrorTree(root.right);
        }
        if (root!=null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }


    public boolean isSymmetric(TreeNode root) {
        if (root==null)return true;
        return isSame(root.left,root.right);

    }
    public boolean isSame(TreeNode A,TreeNode B){
        if (A==null&&B==null)return true;
        if (A==null||B==null)return false;
        if (A.val!=B.val)return false;
        return isSame(A.left,B.right)&&isSame(A.right,B.left);

    }


    public int addDigits(int num) {
        int res = 0;
        while (num>9){
            res+=num%10;
            num = num/10;
        }
        res = res+num;
        if (res>10) res = addDigits(res);
        return  res;
    }


    public int fib(int n) {
        if(n<2)return n;
        int q =0,p=0,r=1;
        for (int i =2;i<n;i++){
            p=q;
            q=r;
            r=(p+q)%(int) (1e9+7);
        }
        return r;
    }


    public int numWays(int n) {
        if (n<3)return n;
        int q = 0,p=1,r=2;
        for(int i=2;i<n;i++){
            q=p;
            p=r;
            r=(p+q)%(int)(1e9+7);
        }
        return r;
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price<min)min=price;
            else if(price-min>res)res=price-min;
        }
        return res;
    }

}