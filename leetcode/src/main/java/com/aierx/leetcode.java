package com.aierx;

import java.io.File;
import java.util.*;

public class leetcode {
    public static void main(String[] args) throws Exception {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        if (2<10){
            System.out.println("aaaaaaaa");
        }else if(3<10){
            System.out.println("bbbbbbbbbbbb");
        }




        Solution solution = new Solution();
        System.out.println(solution.numWays(7));
    }


}
