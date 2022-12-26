package com.aierx;

import org.junit.Test;

import java.util.*;

public class leetcode {
	
	
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
		int i = Integer.bitCount(x ^ y);
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
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int i1 = i + 1; i1 < nums.length; i1++) {
				if (nums[i] == nums[i1] && (i * i1) % k == 0) res++;
			}
		}
		return res;
	}
	
	public int getDecimalValue(ListNode head) {
		int res = 0;
		while (head != null) {
			res *= 2;
			res += head.val;
			head = head.next;
		}
		return res;
	}
	
	public int countPoints(String rings) {
		char[] chars = rings.toCharArray();
		int temp;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < chars.length; i += 2) {
			Integer integer = map.get(chars[i + 1] - 48) != null ? map.get(chars[i + 1] - 48) : 0;
			if (chars[i] == 'R') {
				temp = integer | 1;
				map.put(chars[i + 1] - 48, temp);
			}
			if (chars[i] == 'B') {
				temp = integer | 2;
				map.put(chars[i + 1] - 48, temp);
			}
			if (chars[i] == 'G') {
				temp = integer | 4;
				map.put(chars[i + 1] - 48, temp);
			}
		}
		
		int res = 0;
		for (Integer integer : map.keySet()) {
			if (map.get(integer) == 7) res++;
		}
		
		return res;
	}
	
	public int findNumbers(int[] nums) {
		int res = 0;
		for (int num : nums) {
			if (String.valueOf(num).length() % 2 == 0) res++;
		}
		return res;
	}
	
	public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
		int res = 0;
		for (int i = 0; i < startTime.length; i++) {
			if (queryTime >= startTime[i] && queryTime <= endTime[i]) res++;
		}
		return res;
	}
	
	public int diagonalSum(int[][] mat) {
		int res = 0;
		for (int i = 0; i < mat.length; i++) {
			res += mat[i][i];
			res += mat[i][mat.length - i];
		}
		if ((mat.length) % 2 == 1) {
			int temp = mat.length / 2;
			res -= mat[temp][temp];
		}
		return res;
	}
	
	public int calculate(String s) {
		int x = 1;
		int y = 0;
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			if (aChar == 'A') {
				x = 2 * x + y;
			} else {
				y = 2 * y + x;
			}
		}
		
		return x + y;
	}
	
	public int sumBase(int n, int k) {
		int res = 0;
		while (n >= k) {
			res += n / k;
			n = n % k;
		}
		return res + n;
	}
	
	public boolean winnerOfGame(String colors) {
		int a = 0;
		int b = 0;
		char[] chars = colors.toCharArray();
		for (int i = 1; i < chars.length - 1; i++) {
			if (chars[i - 1] == 'A' && chars[i] == 'A' && chars[i + 1] == 'A') a++;
			if (chars[i - 1] == 'B' && chars[i] == 'B' && chars[i + 1] == 'B') b++;
		}
		
		
		return (a - 1) > b;
	}
	
	List<Integer> list = new ArrayList<>();
	boolean temp = false;
	
	public boolean findTarget(TreeNode root, int k) {
		if (root == null) return temp;
		if (list.contains(root.val)) temp = true;
		;
		list.add(k - root.val);
		findTarget(root.left, k);
		findTarget(root.right, k);
		return true;
	}
	
	
	public int findKthNumber(int n, int k) {
		int cuee = 1;
		k--;
		while (k > 0) {
			int step = getstep(cuee, n);
			if (step < k) {
				k -= step;
				cuee++;
			} else {
				cuee *= 10;
				k--;
			}
		}
		return cuee;
	}
	
	private int getstep(int cuee, int n) {
		int step = 0;
		long fisrt = cuee;
		long fast = cuee;
		while (fisrt <= n) {
			step += Math.max(fast, n) - fisrt + 1;
			fisrt = fisrt * 10;
			fast = fast * 10 + 9;
		}
		return step;
	}
	
	StringBuilder builder = new StringBuilder();
	
	public String tree2str(TreeNode root) {
		if (root == null) return "";
		builder.append(root.val);
		if (root.right != null) {
			builder.append("(");
			tree2str(root.left);
			tree2str(root.right);
			builder.append(")");
		} else {
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
				return o2.length() - o1.length();
			}
		});
		ArrayList<String> strings1 = new ArrayList<>();
		for (String string : strings) {
			int tem = string.length();
			for (int i = 0; i < string.length(); i++) {
				String substring = string.substring(0, string.length() - i - 1);
				if (!strings.contains(substring)) break;
				tem--;
			}
			if (tem == 1) {
				strings1.add(string);
			}
		}
		ArrayList<String> res = new ArrayList<>();
		int max = strings1.get(0).length();
		for (String s : strings1) {
			if (s.length() == max) {
				res.add(s);
			}
		}
		for (int i = 0; i < res.get(0).length(); i++) {
			int min = 0;
		}
		return "aaaaa";
	}
	
	public String reversePrefix(String word, char ch) {
		Stack<Character> characters = new Stack<>();
		char[] chars = word.toCharArray();
		int i = 0;
		while (ch != chars[i]) {
			characters.push(chars[i]);
			i++;
		}
		StringBuilder stringBuilder = new StringBuilder();
		characters.push(chars[i++]);
		while (characters.size() != 0) {
			stringBuilder.append(characters.pop());
		}
		while (i < word.length()) {
			stringBuilder.append(chars[i]);
			i++;
		}
		return stringBuilder.toString();
		
	}
	
	public String firstPalindrome(String[] words) {
		for (String word : words) {
			char[] chars = word.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if (i == chars.length / 2) return word;
				if (chars[i] == chars[chars.length - i - 1]) continue;
				else break;
			}
		}
		return "";
	}
	
	public int[][] flipAndInvertImage(int[][] image) {
		for (int i = 0; i < image.length; i++) {
			for (int i1 = 0; i1 < image[i].length; i1++) {
				if (image[i][i1] == 1) image[i][i1] = 0;
				else image[i][i1] = 1;
			}
			for (int i1 = 0; i1 < image[i].length / 2; i1++) {
				int temp = image[i][i1];
				image[i][i1] = image[i][image[i].length - i1 - 1];
				image[i][image[i].length - i1 - 1] = temp;
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
			if (i < chars.length) {
				stringBuilder.append((char) (chars[i - 1] + chars[i] - 48));
			}
		}
		
		return stringBuilder.toString();
	}
	
	HashSet<Integer> integers = new HashSet<>();
	
	public int numColor(TreeNode root) {
		if (root == null) return 0;
		integers.add(root.val);
		numColor(root.left);
		numColor(root.right);
		return integers.size();
	}
	
	int max = 0;
	
	public int maxDepth(TreeNode root) {
		deep(root, 1);
		return max;
		
	}
	
	void deep(TreeNode rot, int high) {
		if (rot == null) return;
		if (high > max) max = high;
		deep(rot.left, high + 1);
		deep(rot.right, high + 1);
	}
	
	
	public int[][] imageSmoother(int[][] img) {
		int[][] arr = new int[img.length][img[0].length];
		
		for (int i = 0; i < arr.length; i++) {
			int temp = 0;
			int count = 0;
			for (int j = 0; j < arr[i].length; j++) {
				if (i - 1 > 0 && j - 1 > 0) {
					temp += img[i - 1][j - 1];
					count++;
				}
				if (i - 1 > 0) {
					temp += img[i - 1][j];
					count++;
				}
				if (i - 1 > 0 && j + 1 < arr[i].length) {
					temp += img[i - 1][j + 1];
					count++;
				}
				
				if (j + 1 < arr[i].length) {
					temp += img[i][j + 1];
					count++;
				}
				if (i + 1 < arr.length && j + 1 < img[i].length) {
					temp += img[i + 1][j + 1];
					count++;
				}
				
				if (i + 1 < arr.length) {
					temp += img[i + 1][j];
					count++;
				}
				if (j - 1 > 0 && i + 1 < arr.length) {
					temp += img[i + 1][j - 1];
					count++;
				}
				if (j - 1 > 0) {
					temp += img[i][j - 1];
					count++;
				}
				temp += img[i][j];
				arr[i][j] = (int) Math.floor(temp / (count + 1));
			}
		}
		return arr;
	}
	
	int getAvg(int... object) {
		int res = 0;
		for (int i : object) {
			res += i;
		}
		return res / object.length;
		
	}
	
	public int sumOfUnique(int[] nums) {
		if (nums.length == 1) return nums[0];
		ArrayList<Integer> a = new ArrayList<>();
		for (int num : nums) {
			a.add(num);
		}
		ArrayList<Integer> integers1 = new ArrayList<>();
		for (int i = 1; i < a.size(); i++) {
			if (a.get(i).equals(a.get(i - 1))) integers1.add(a.get(i));
		}
		int res = 0;
		for (Integer integer : integers1) {
			if (!integers1.contains(integer)) {
			}
		}
		return res;
	}
	
	@Test
	public void taest1() throws InterruptedException {
		int[][] a = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
		int[][] ints = imageSmoother(a);
		System.out.println();
	}
	
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode h1 = head, h3 = head;
		for (int i = 0; i < k; i++) {
			h3 = h3.next;
		}
		
		while (h3 != null) {
			h1 = h1.next;
			h3 = h3.next;
		}
		
		return h1;
	}
	
	public TreeNode invertTree(TreeNode root) {
		if (root != null) {
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			invertTree(root.left);
			invertTree(root.right);
		}
		return root;
	}
	
	public int prefixCount(String[] words, String pref) {
		int res = 0;
		for (String word : words) {
			if (word.startsWith(pref)) {
				res++;
			}
		}
		return res;
	}
	
	public String sortString(String s) {
		int[] arr = new int[26];
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			arr[chars[i] - 97] += 1;
		}
		int flag = s.length();
		StringBuilder res = new StringBuilder();
		int count = 0;
		while (flag > 0) {
			while (count < 26) {
				if (arr[count] > 0) {
					flag--;
					arr[count]--;
					res.append((char) (count + 97));
				}
				count++;
			}
			count--;
			while (count >= 0) {
				if (arr[count] > 0) {
					flag--;
					arr[count]--;
					res.append((char) (count + 97));
				}
				count--;
			}
			count++;
		}
		return res.toString();
	}
	
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null) {
			return root2;
		}
		if (root2 == null) {
			return root1;
		}
		TreeNode node = new TreeNode(root1.val + root2.val);
		node.left = mergeTrees(root1.left, root2.left);
		node.right = mergeTrees(root1.right, root2.right);
		return node;
	}
	
	
	public int minOperations(int[] nums) {
		if (nums.length == 0 || nums.length == 1) return 0;
		int res = 0;
		int temp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= temp) {
				res = res + (temp - nums[i] + 1);
				temp = temp + 1;
			} else {
				temp = nums[i];
			}
		}
		return res;
	}
	
	
	public int largestAltitude(int[] gain) {
		if (gain.length == 0) return 0;
		if (gain.length == 1) return gain[0];
		
		int max = gain[0];
		int cur = gain[0];
		
		for (int i : gain) {
			cur += i;
			if (cur > max) {
				max = cur;
			}
		}
		
		return max;
	}
	
	public String restoreString(String s, int[] indices) {
		char[] chars = s.toCharArray();
		
		for (int i = 0; i < indices.length; i++) {
			int min = i;
			for (int j = i; j < indices.length; j++) {
				if (indices[j] < indices[min]) {
					min = j;
				}
			}
			int temp = indices[min];
			indices[min] = indices[i];
			indices[i] = temp;
			
			char tema = chars[min];
			chars[min] = chars[i];
			chars[i] = tema;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (char aChar : chars) {
			stringBuilder.append(aChar);
		}
		return stringBuilder.toString();
	}
	
	
	public boolean squareIsWhite(String coordinates) {
		char[] chars = coordinates.toCharArray();
		char a = chars[0];
		int c = a - 'a' + 1;
		int d = chars[1] - '0';
		return (c + d) % 2 != 0;
	}
	
	public int numOfStrings(String[] patterns, String word) {
		int res = 0;
		for (String pattern : patterns) {
			if (word.contains(pattern)) {
				res++;
			}
		}
		return res;
	}
	
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> res = new ArrayList();
		
		for (int i = left; i <= right; i++) {
			int flag = 0;
			int temp = i;
			while (temp > 0) {
				int a = temp % 10;
				temp = temp / 10;
				if (a == 0) {
					flag = 1;
					break;
				}
				if (i % a != 0) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				res.add(i);
			}
		}
		return res;
	}
	
	public int minBitFlips(int start, int goal) {
		int res = 0;
		while (start != 0 || goal != 0) {
			int a = start & 1;
			int b = goal & 1;
			if (a != b) {
				res++;
			}
			if (start != 0)
				start = start >>> 1;
			if (goal != 0)
				goal = goal >>> 1;
		}
		return res;
	}
	
	public int[] replaceElements(int[] arr) {
		int max = maxIndex(arr, 1);
		for (int i = 0; i < arr.length - 1; i++) {
			if (max > i) {
				arr[i] = arr[max];
			} else {
				max = maxIndex(arr, i + 1);
				arr[i] = arr[max];
			}
		}
		arr[arr.length - 1] = -1;
		return arr;
	}
	
	public int maxIndex(int[] arr, int begin) {
		int max = begin;
		
		while (begin < arr.length) {
			if (arr[max] < arr[begin]) {
				max = begin;
			}
			begin++;
		}
		return max;
	}
	
	public int[] countBits(int n) {
		int[] res = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			int temp = i;
			while (temp > 0) {
				int c = temp & 1;
				if (c == 1) res[i]++;
				temp = temp >>> 1;
			}
		}
		return res;
	}
	
	
	public boolean checkTree(TreeNode root) {
		if (root == null) return false;
		int rootVal = root.val;
		List<TreeNode> list = new ArrayList<TreeNode>();
		int other = 0;
		list.add(root);
		while (list.size() > 0) {
			TreeNode aa = list.get(0);
			if (aa.left != null) {
				list.add(aa.left);
			}
			if (aa.right != null) {
				list.add(aa.right);
			}
			other += aa.val;
			list.remove(aa);
		}
		return other == (2 * rootVal);
	}
	
	
	public boolean isPalindrome(char[] x, int offset, int len) {
		for (int i = 0; i < len / 2; i++) {
			if (x[offset + i] != x[offset + len - 1 - i]) {
				return false;
			}
		}
		return true;
	}
	
	public String longestPalindrome(String s) {
		int len = s.length();
		char[] chars = s.toCharArray();
		if (s.length() < 2) return s;
		boolean[][] booleans = new boolean[len][len];
		
		int j, maxLen = 1, begin = 0;
		for (int L = 2; L < len; L++) {
			for (int i = 0; i < len; i++) {
				j = L + i - 1;
				if (j >= len) {
					break;
				}
				if (chars[i] != chars[j]) {
					booleans[i][j] = false;
				} else {
					if (j - i < 3) {
						booleans[i][j] = true;
					} else {
						booleans[i][j] = booleans[i + 1][j - 1];
					}
				}
				if (booleans[i][j] && j - i + 1 > maxLen) {
				}
				
			}
			
		}
		
		return "";
	}
	
	
	public TreeNode sortedArrayToBST(int[] nums) {
		return getNode(nums, 0, nums.length - 1);
		
	}
	
	private TreeNode getNode(int[] nums, int i, int i1) {
		if (i > i1) {
			return null;
		}
		int middle = (i1 + i) / 2;
		TreeNode node = new TreeNode(nums[middle]);
		node.left = getNode(nums, i, middle - 1);
		node.right = getNode(nums, middle + 1, i1);
		return node;
	}
	
	public int sumOfLeftLeaves(TreeNode root) {
		return traverse(root, false);
	}
	
	private int traverse(TreeNode root, boolean isLeft) {
		if (root == null) return 0;
		if (root.right == null && root.left == null && isLeft)
			return root.val;
		return traverse(root.left, true) + traverse(root.right, false);
	}
	
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		int temp = Integer.MAX_VALUE;
		if (root.left != null) {
			temp = Math.min(minDepth(root.left), temp);
		}
		if (root.right != null) {
			temp = Math.min(minDepth(root.right), temp);
		}
		return temp + 1;
	}
	
	private int sum(int n) throws InterruptedException {
		if (n == 1) return 1;
		ArrayList<String> strings = new ArrayList<>();
		strings.add("leiwenyong1" + n);
		strings.add("leiwenyong1" + n);
		return sum(n - 1);
		
	}
	
	public String convert(String s, int numRows) {
		if (numRows == 1) return s;
		StringBuilder[] arr = new StringBuilder[numRows];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new StringBuilder();
		}
		int mod = numRows * 2 - 2;
		for (int i = 0; i < s.length(); i++) {
			int x = i % mod;
			if (x >= numRows) {
				arr[mod - x].append(s.charAt(i));
			} else {
				arr[x % numRows].append(s.charAt(i));
			}
		}
		StringBuilder res = new StringBuilder();
		for (StringBuilder stringBuilder : arr) {
			res.append(stringBuilder);
		}
		return res.toString();
	}
	
	
	public String intToRoman(int num) {
		int[] ii = {1, 5, 10, 50, 100, 500, 1000};
		char[] ss = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		char[] str = new char[20];
		int c = 0;
		StringBuilder builder = new StringBuilder();
		for (int i = ii.length - 3; i >= 0; i -= 2) {
			while (num >= 1000) {
				str[c++] = ss[i + 2];
				num = num - 1000;
			}
			if (num < ii[i]) continue;
			if (num / ii[i] == 9) {
				num = num - ii[i] * 9;
				str[c++] = ss[i];
				str[c++] = ss[i + 2];
				continue;
			}
			if (num / ii[i] == 4) {
				num = num - ii[i] * 4;
				str[c++] = ss[i];
				str[c++] = ss[i + 1];
				continue;
			}
			if (num / ii[i] >= 5) {
				num = num - ii[i + 1];
				str[c++] = ss[i + 1];
			}
			while (num >= ii[i]) {
				num = num - ii[i];
				str[c++] = ss[i];
			}
		}
		return new String(str, 0, c);
	}
	
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int len = nums.length;
		if (len < 4) return res;
		Arrays.sort(nums);
		for (int i = 0; i < len - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			if ((long) nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue;
			if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
			for (int j = i + 1; j < len - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) continue;
				if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
				if ((long) nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) continue;
				int left = j + 1;
				int right = len - 1;
				while (left < right) {
					long temp = nums[i] + nums[j] + nums[left] + nums[right];
					if (temp == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						while (left < right && nums[left] == nums[++left]) ;
						while (left < right && nums[right] == nums[--right]) ;
					} else if (temp < target) {
						while (left < right && nums[left] == nums[++left]) ;
					} else {
						while (left < right && nums[right] == nums[--right]) ;
					}
				}
			}
		}
		return res;
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		int len = nums.length;
		if (len < 3) return res;
		Arrays.sort(nums);
		for (int i = 0; i < len - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			if (nums[i] > 0) break;
			if ((nums[i] + nums[len - 1] + nums[len - 2]) < 0) continue;
			int left = i + 1;
			int right = len - 1;
			while (left < right) {
				int temp = nums[i] + nums[left] + nums[right];
				if (temp == 0) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while (left < right && nums[left] == nums[++left]) ;
					while (left < right && nums[right] == nums[--right]) ;
				} else if (temp < 0) {
					while (left < right && nums[left] == nums[++left]) ;
				} else {
					while (left < right && nums[right] == nums[--right]) ;
				}
			}
		}
		return res;
	}
	
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) return list1;
		if (list2 == null || list1 == null) {
			return list1 == null ? list2 : list1;
		}
		ListNode res;
		ListNode ret;
		if (list1.val > list2.val) {
			res = list2;
			ret = list2;
			list2 = list2.next;
		} else {
			res = list1;
			ret = list2;
			list1 = list1.next;
		}
		while (list2 != null || list1 != null) {
			if (list1 == null || list2 == null) {
				res.next = list1 == null ? list2 : list1;
				break;
			} else if (list1.val > list2.val) {
				res.next = list2;
				res = res.next;
				list2 = list2.next;
			} else {
				res.next = list1;
				res = res.next;
				list1 = list1.next;
			}
		}
		return ret;
	}
	
	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0) {
			return 0;
		}
		for (int i = 0; i < nums.length; i++) {
			if (target >= nums[i] && (i + 1 <= nums.length || target < nums[i + 1])) {
				return target == nums[i] ? i : i + 1;
			}
		}
		return 0;
	}
	
	
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode ret = head;
		head = head.next;
		ListNode tmp = ret;
		while (head != null) {
			if (head.val != tmp.val) {
				tmp.next = head;
				tmp = tmp.next;
				head = head.next;
				tmp.next = null;
			} else {
				head = head.next;
			}
		}
		return ret;
	}
	
	
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums1.length; i++) {
			for (int i1 = nums2.length - 1; i1 >= 0; i1--) {
				if (nums1[i] == nums2[i1]) break;
				if (nums2[i1] > nums1[i]) {
					stack.add(nums2[i1]);
				}
			}
			nums1[i] = stack.size() == 0 ? -1 : stack.pop();
			stack.clear();
		}
		return nums1;
	}
	
	
	int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		}
		if (divisor == 1) {
			return dividend;
		}
		if (divisor == -1) {
			if (dividend > Integer.MIN_VALUE) {
				return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
			}
			return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
		}
		int a = dividend;
		int b = divisor;
		int sign = 1;
		if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
			sign = -1;
		}
		a = a > 0 ? a : -a;
		b = b > 0 ? b : -b;
		int res = div(a, b);
		if (sign > 0) {
			return res > Integer.MAX_VALUE ? Integer.MIN_VALUE : res;
		}
		return -res;
	}
	
	int div(int a, int b) {  // 似乎精髓和难点就在于下面这几句
		if (a < b) {
			return 0;
		}
		int count = 1;
		int tb = b; // 在后面的代码中不更新b
		while ((tb + tb) <= a) {
			count = count + count; // 最小解翻倍
			tb = tb + tb; // 当前测试的值也翻倍
		}
		return count + div(a - tb, b);
	}
	
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (n == 1) {
			return head.next;
		}
		ListNode tmp = head;
		ListNode ret = head;
		int count = 0;
		while (count < n) {
			tmp = tmp.next;
			count++;
		}
		
		while (tmp.next != null) {
			tmp = tmp.next;
			head = head.next;
		}
		
		head.next = head.next.next;
		return ret;
	}
	
	List<Integer> arr1 = new ArrayList();
	
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null) {
			return null;
		}
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		arr1.add(root.val);
		return arr1;
	}
	
	public boolean hasCycle(ListNode head) {
		List<ListNode> nodes = new ArrayList<>();
		while (head != null) {
			for (ListNode node : nodes) {
				if (head == node) {
					return true;
				}
			}
			nodes.add(head);
			head = head.next;
		}
		return false;
	}
	
	public int singleNumber(int[] nums) {
		int min, tmp;
		for (int i = 0; i < nums.length; i++) {
			min = i;
			for (int j = i; j < nums.length; j++) {
				if (nums[min] > nums[j]) {
					min = j;
				}
			}
			tmp = nums[min];
			nums[min] = nums[i];
			nums[i] = tmp;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) continue;
			if (nums[i] != nums[i - 1]) return nums[i - 1];
		}
		return nums[nums.length - 1];
	}
	
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int i = 0;
		StringBuilder builder = new StringBuilder();
		while (i < s.length()) {
			if (Character.isLetterOrDigit(s.charAt(i)))
				builder.append(s.charAt(i));
			i++;
		}
		if (builder.toString().length() == 0 || builder.toString().length() == 1) {
			return true;
		}
		i = 0;
		for (int j = builder.length() - 1; j > i; j--) {
			if (builder.charAt(j) != builder.charAt(i))
				return false;
			i++;
		}
		return true;
	}
	

	
	public static int maxProfit(int[] prices) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				if (max < (prices[j] - prices[i]) && (prices[j] - prices[i]) > 0) {
					max = prices[j] - prices[i];
				}
			}
		}
		return max == Integer.MIN_VALUE ? 0 : max;
	}
	
	
	public int lengthOfLastWord(String s) {
		String[] s1 = s.split(" ");
		return s1[s1.length - 1].length();
	}
	
	public int[] plusOne(int[] digits) {
		int i = digits.length - 1;
		boolean flag = true;
		for (; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				flag = false;
				digits[i] = digits[i] + 1;
				break;
			}
		}
		if (flag) {
			List<Integer> integers = new ArrayList<>();
			integers.add(1);
			for (int ignored : digits) {
				integers.add(0);
			}
			return integers.stream().mapToInt(Integer::intValue).toArray();
		}
		return digits;
	}
	
	public static void main(String[] args) throws Exception {
		addBinary("110","1");
	}
	
	public static String addBinary(String a, String b) {
		int i = a.length() > b.length() ? a.length() + 1 : b.length() + 1;
		boolean flag = false;
		StringBuilder builder = new StringBuilder();
		for (int i1 = 0; i1 < i; i1++) {
			if (i1 > a.length() -1 || i1 > b.length() -1) {
				String s1 = a.length() > b.length() ? a : b;
				while (i1 < s1.length()) {
					if (flag){
						builder.append(s1.charAt(i1));
					}
					i1++;
				}
				break;
			}
			int count = (int) a.charAt(i1) + (int) b.charAt(i1);
			if (!flag) {
				if (count > 1) {
					builder.append(0);
					flag = true;
				} else {
					builder.append(count);
					flag = false;
				}
				
			} else {
				if (count > 0) {
					builder.append(count - 1);
					flag = true;
				} else {
					builder.append(1);
					flag = false;
				}
			}
		}
		if (flag) {
			builder.append(1);
		}
		return builder.reverse().toString();
	}
	
}

