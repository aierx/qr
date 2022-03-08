package com.aierx;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        while (in > out) {
            if (treeNodes[out] != null) {
                list.add(treeNodes[out].val);
                System.out.println(treeNodes[out].val);
                if (treeNodes[out].left != null) treeNodes[in++] = treeNodes[out].left;
                if (treeNodes[out].right != null) treeNodes[in++] = treeNodes[out].right;
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
        return (A != null && B != null) &&
                (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || B.val != A.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);

    }

    public boolean isSame(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        if (A.val != B.val) return false;
        return isSame(A.left, B.right) && isSame(A.right, B.left);

    }


    public int addDigits(int num) {
        int res = 0;
        while (num > 9) {
            res += num % 10;
            num = num / 10;
        }
        res = res + num;
        if (res > 10) res = addDigits(res);
        return res;
    }


    public int fib(int n) {
        if (n < 2) return n;
        int q = 0, p = 0, r = 1;
        for (int i = 2; i < n; i++) {
            p = q;
            q = r;
            r = (p + q) % (int) (1e9 + 7);
        }
        return r;
    }


    public int numWays(int n) {
        if (n < 3) return n;
        int q = 0, p = 1, r = 2;
        for (int i = 2; i < n; i++) {
            q = p;
            p = r;
            r = (p + q) % (int) (1e9 + 7);
        }
        return r;
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) min = price;
            else if (price - min > res) res = price - min;
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int pre = 0, max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);

        }
        return max;
    }

    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray1(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }


    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] + grid[i - 1][j - 1]);
            }
        }
        return dp[row][col];
    }

    /**
     * [1,2,4,1,7,8,3]
     */


}