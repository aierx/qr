package com.aierx;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.lang.instrument.Instrumentation;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class leetcode {
    public static void main(String[] args) throws Exception {

        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        solution.maxSubArray(a);
    }

    private final int[] nums = new int[]{1, 3};

    @Test
    public void XOR() {

        int count = (int) Math.pow(2, nums.length);
        int result = 0;
        for (int i = 0; i < count; i++) {
            String binaryString = Integer.toBinaryString(i);
            char[] chars = binaryString.toCharArray();
            int sum = 0;
            for (int j = chars.length - 1; j >= 0; j--) {
                if (chars[j] == '1') {
                    sum ^= nums[chars.length - 1 - j];
                }
            }
            result += sum;
        }


    }

    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.startsWith("++") || operation.endsWith("++")) {
                res++;
            } else {
                res--;
            }
        }

        return res;


    }

    public int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] res = new int[len + 1];
        res[0] = first;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] ^ encoded[i];
        }
        return res;
    }

    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            String[] s = sentence.split(" ");
            max = Math.max(max, s.length);
        }
        return max;
    }

    @Test
    public void test11() {
        System.out.println('A' - 64);

    }

    public int minimumSum(int num) {
        Integer integer = new Integer(num);
        char[] chars = integer.toString().toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(aChar - 48);
        }
        list.sort(Comparator.comparingInt(o -> o));
        int res = 0;
        res += list.get(0) * 10;
        res += list.get(1) * 10;
        res += list.get(2);
        res += list.get(3);
        return res;
    }

    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            res = res ^ (start + 2 * i);
        }
        return res;
    }


    public int countKDifference(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(nums[i] - nums[j]) == Math.abs(k)) {
                    res++;
                }

            }
        }
        return res;
    }

    @Test
    public void test1111() {
        balancedStringSplit(
                "RLRRLLRLRL");
    }

    public int numJewelsInStones(String jewels, String stones) {
        char[] chars = jewels.toCharArray();
        ArrayList<Character> chars1 = new ArrayList<>();
        for (char aChar : chars) {
            chars1.add(aChar);
        }
        char[] chars2 = stones.toCharArray();
        int res = 0;
        for (char c : chars2) {
            if (chars1.contains(c)) {
                res++;
            }
        }
        return res;
    }


    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int[] account : accounts) {
            int temp = 0;
            for (int i : account) {
                temp += i;
            }
            res = Math.max(res, temp);
        }
        return res;
    }

    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int res = 0;
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.push('C');
                res = Math.max(stack.size(), res);
            } else if (aChar == ')') {
                stack.pop();
            }
        }
        return res;
    }

    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    res++;
                }
            }
        }
        return res;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (max <= candies[i] + extraCandies) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return new ArrayList<Boolean>(res);
    }

    public int game(int[] guess, int[] answer) {
        int res = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                res++;
            }
        }
        return res;
    }

    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> characters = new Stack<>();
        characters.push(chars[0] == 'L' ? 'R' : 'L');
        int res = 0;
        for (int i = 1; i < chars.length; i++) {
            if (characters.size() > 0 && characters.peek() == chars[i]) {
                characters.pop();
                if (characters.size() == 0) {
                    res++;
                }
                continue;
            }
            characters.push(chars[0] == 'L' ? 'R' : 'L');
        }
        return res + 1;
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0;
        if ("type".equals(ruleKey)) {
            index = 0;
        }
        if ("color".equals(ruleKey)) {
            index = 1;
        }
        if ("name".equals(ruleKey)) {
            index = 2;
        }
        int res = 0;
        for (List<String> item : items) {
            if (item.get(index) == ruleValue) {
                res++;
            }
        }
        return res;

    }

    public int findCenter(int[][] edges) {
        int res = edges[0][0];

        for (int[] edge : edges) {
            int temp = 0;
            for (int i : edge) {
                if (i == res) {
                    temp++;
                }
            }
            if (temp == 0) {
                return edges[0][1];
            }
        }
        return res;
    }

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[j];
                j++;
            } else {
                res[i] = nums[n + j];
            }
        }
        return res;
    }

    public int minCount(int[] coins) {
        int res = 0;
        for (int coin : coins) {
            res += coin / 2;
            if (coin % 2 > 0) {
                res += 1;
            }
        }
        return res;
    }

    @Test
    public void test1() {
        int[] arr = new int[]{10, 11, 12};
        sumOddLengthSubarrays(arr);
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int i = 1; i < arr.length + 1; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < arr.length - i + 1; j = j + 1) {
                    int temp = 0;
                    for (int c = 0; c < i; c++) {
                        temp += arr[j + c];
                    }
                    res += temp;
                }
            }
        }
        System.out.println(res);
        return res;
    }


    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }


    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        int res = 0;
        for (int[] rectangle : rectangles) {
            int min = Math.min(rectangle[0], rectangle[1]);
            if (min == max) {
                res++;
                continue;
            }
            if (min > max) {
                max = min;
                res = 0;
            }
        }
        return res;
    }

    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                list.add(nums[i + 1]);
            }
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    public int subtractProductAndSum(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int a = 1;
        int b = 0;
        for (char aChar : chars) {
            a *= (aChar - 48);
            b += (aChar - 48);
        }
        return a - b;
    }

    List<Integer> arr = new ArrayList<>();

    @Test
    public void test2() {
        int[] nums = new int[]{0, 1, 2, 3, 4};
        int[] index = new int[]{0, 1, 2, 2, 1};
        int[] targetArray = createTargetArray(nums, index);
        for (int num : targetArray) {
            System.out.println(num);
        }


    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] arr = new int[index.length];
        Arrays.fill(arr, -1);
        for (int i = 0; i < index.length; i++) {
            if (arr[index[i]] == -1) {
                arr[index[i]] = nums[i];
            } else {
                int temp = index[i];
                while (arr[temp] != -1) {
                    temp++;
                }
                ;
                for (; temp != index[i]; temp--) {
                    arr[temp] = arr[temp - 1];
                }
                arr[index[i]] = nums[i];
            }
        }
        return arr;
    }

    public int numberOfSteps(int num) {
        int res = 0;
        while (num != 0) {
            res++;
            if (num % 2 == 1) {
                num = num - 1;
            } else {
                num = num / 2;
            }
        }
        return res;
    }

    public String interpret(String command) {
        char[] chars = command.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'G') {
                builder.append('G');
                continue;
            }
            if (chars[i] == '(' && chars[i + 1] == ')') {
                builder.append('o');
                i++;
                continue;
            }
            builder.append("al");
            i = i + 3;
        }
        return builder.toString();

    }


    public int maxProductDifference(int[] nums) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int num : nums) {
            integers.add(num);
        }
        integers.sort(Comparator.comparingInt(o -> o));
        int min = integers.get(0) * integers.get(1);
        int max = integers.get(integers.size() - 1) * integers.get(integers.size() - 2);
        return max - min;
    }


    public int minMovesToSeat(int[] seats, int[] students) {
        List<Integer> seatsList = new ArrayList<>();
        List<Integer> studentsList = new ArrayList<>();
        for (int num : seats) {
            seatsList.add(num);
        }
        for (int num : students) {
            studentsList.add(num);
        }
        seatsList.sort(Comparator.comparingInt(o -> o));
        studentsList.sort(Comparator.comparingInt(o -> o));


        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(studentsList.get(i) - seatsList.get(i));
        }
        return res;
    }

    public int countConsistentStrings(String allowed, String[] words) {
        char[] chars = allowed.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
        for (char aChar : chars) {
            characters.add(aChar);
        }
        int res = words.length;
        for (String word : words) {
            char[] chars1 = word.toCharArray();
            for (char c : chars1) {
                if (!characters.contains(c)) {
                    res--;
                    break;
                }
            }
        }
        return res;
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            if (i + 1 < points.length) {
                res += Math.max(Math.abs(points[i][0] - points[i + 1][0]), Math.abs(points[i][1] - points[i + 1][1]));
            }
        }
        return res;
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            int res = 0;
            for (int a : nums) {
                if (a < num) res++;
            }
            arr[i] = res;
            i++;
        }
        return arr;
    }

    public String destCity(List<List<String>> paths) {
        Set<String> citiesA = new HashSet<String>();
        for (List<String> path : paths) {
            citiesA.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!citiesA.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> integers = new ArrayList<>();
        for (int i : nums) {
            integers.add(i);
        }
        integers.sort(Comparator.comparingInt(o -> o));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) > target) break;
            if (integers.get(i) == target) {
                res.add(i);
            }
        }
        return res;
    }

    int res = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val > low && root.val < high) res = res + root.val;
        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



    public boolean checkIfPangram(String sentence) {
        char[] chars = sentence.toCharArray();
        if (chars.length < 26) return false;
        int[] a = new int[26];
        for (char aChar : chars) {
            a[aChar - 97] = 1;
        }
        for (int i : a) {
            if (i == 0) return false;
        }
        return true;
    }

    public int hammingDistance(int x, int y) {
        int i = Integer.bitCount(x^y);
        return i;
    }


    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : word1) {
            stringBuilder.append(s);
        }

        StringBuilder stringBuilder1 = new StringBuilder();
        for (String s : word2) {
            stringBuilder1.append(s);
        }
        return stringBuilder.toString().equals(stringBuilder1.toString());
    }


    public int countPairs(int[] nums, int k) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i+1; i1 < nums.length; i1++) {
                if (nums[i]==nums[i1]&&(i*i1)%k==0)res++;
            }
        }
        return res;
    }

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head!=null){
            res*=2;
            res+=head.val;
            head=head.next;
        }
        return res;
    }

    public int countPoints(String rings) {
        char[] chars = rings.toCharArray();
        int temp;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i+=2) {
            Integer integer = map.get(chars[i+1]-48)!=null?map.get(chars[i+1]-48):0;
            if (chars[i]=='R'){
                temp = integer|1;
                map.put(chars[i+1]-48,temp);
            }
            if (chars[i]=='B'){
                temp = integer|2;
                map.put(chars[i+1]-48,temp);
            }
            if (chars[i]=='G'){
                temp = integer|4;
                map.put(chars[i+1]-48,temp);
            }
        }

        int res = 0;
        for (Integer integer : map.keySet()) {
            if(map.get(integer)==7)res++;
        }

        return res;
    }

    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
           if( String.valueOf(num).length()%2==0)res++;
        }
        return res;
    }
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res=0;
        for (int i = 0; i < startTime.length; i++) {
            if(queryTime>=startTime[i]&&queryTime<=endTime[i])res++;
        }
        return res;
    }

    public int diagonalSum(int[][] mat) {
        int res=0;
        for (int i = 0; i < mat.length; i++) {
            res +=mat[i][i];
            res+=mat[i][mat.length-i];
        }
        if ((mat.length)%2==1){
            int temp = mat.length/2;
            res-=mat[temp][temp];
        }
        return res;
    }

    public int calculate(String s) {
        int x = 1;
        int y = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar=='A'){
                x = 2*x+y;
            }else {
                y=2*y+x;
            }
        }

        return x+y;
    }

    public int sumBase(int n, int k) {
        int res = 0;
        while (n>=k){
           res+= n/k;
           n=n%k;
        }
        return res+n;
    }

    public boolean winnerOfGame(String colors) {
        int a = 0;
        int b = 0;
        char[] chars = colors.toCharArray();
        for (int i = 1; i < chars.length-1; i++) {
            if (chars[i-1]=='A'&&chars[i]=='A'&&chars[i+1]=='A')a++;
            if (chars[i-1]=='B'&&chars[i]=='B'&&chars[i+1]=='B')b++;
        }


        return (a-1)>b;
    }
    List<Integer> list = new ArrayList<>();
    boolean temp = false;
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)return temp;
        if(list.contains(root.val)) temp = true;;
        list.add(k-root.val);
        findTarget(root.left,k);
        findTarget(root.right,k);
        return true;
    }



    public int findKthNumber(int n, int k) {
        int cuee = 1;
        k--;
        while (k>0){
            int step = getstep(cuee,n);
            if (step<k){
                k-=step;
                cuee++;
            }else {
                cuee*=10;
                k--;
            }
        }
        return cuee;
    }

    private int getstep(int cuee, int n) {
        int step = 0;
        long fisrt = cuee;
        long fast = cuee;
        while (fisrt<=n){
            step+=Math.max(fast,n)-fisrt+1;
            fisrt=fisrt*10;
            fast = fast*10+9;
        }
        return step;
    }

    StringBuilder builder = new StringBuilder();
    public String tree2str(TreeNode root) {
        if(root==null)return "";
        builder.append(root.val);
        if(root.right!=null){
            builder.append("(");
            tree2str(root.left);
            tree2str(root.right);
            builder.append(")");
        }else {
            tree2str(root.left);
            tree2str(root.right);
        }

        return builder.toString();
    }


    public String longestWord(String[] words) {
        ArrayList<String> strings = new ArrayList<>();
        for (String word : words) {
            strings.add(word);
        }
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        ArrayList<String> strings1 = new ArrayList<>();
        for (String string : strings) {
            int tem = string.length();
            for (int i = 0; i < string.length(); i++) {
                String substring = string.substring(0, string.length() - i - 1);
                if(!strings.contains(substring))break;
                tem--;
            }
            if (tem==1){
                strings1.add(string);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        int max = strings1.get(0).length();
        for (String s : strings1) {
            if (s.length()==max){
                res.add(s);
            }
        }
        for (int i = 0; i < res.get(0).length(); i++) {
            int min = 0;
        }
        return  "aaaaa";
    }

    public String reversePrefix(String word, char ch) {
        Stack<Character> characters = new Stack<>();
        char[] chars = word.toCharArray();
        int i = 0;
        while (ch!=chars[i]){
            characters.push(chars[i]);
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        characters.push(chars[i++]);
        while (characters.size()!=0){
            stringBuilder.append(characters.pop());
        }
        while (i<word.length()){
            stringBuilder.append(chars[i]);
            i++;
        }
        return stringBuilder.toString();

    }

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i==chars.length/2)return word;
                if (chars[i]==chars[chars.length-i-1])continue;
                else break;
            }
        }
        return "";
    }
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int i1 = 0; i1 < image[i].length; i1++) {
                if (image[i][i1]==1)image[i][i1]=0;
                else image[i][i1]=1;
            }
            for (int i1 = 0; i1 < image[i].length/2; i1++) {
                int temp = image[i][i1];
                image[i][i1] = image[i][image[i].length-i1-1];
                image[i][image[i].length-i1-1] = temp;
            }
        }
        return image;
    }

    public String replaceDigits(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
            i++;
            if(i<chars.length){
                stringBuilder.append((char)(chars[i-1]+chars[i]-48));
            }
        }

        return stringBuilder.toString();
    }
    @Test
    public void taest1() throws InterruptedException {
        replaceDigits(
                "a1b2c3d4e");
    }

}
