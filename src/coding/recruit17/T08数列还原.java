package coding.recruit17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 题目描述 牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，其中有一些位置（不超过 10 个）看不清了，但是牛牛记得这个数列顺序对的数量是
 * k，顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。 输入描述:
 * 
 * 每个输入包含一个测试用例。每个测试用例的第一行包含两个整数 n 和 k（1 <= n <= 100, 0 <= k <= 1000000000），接下来的 1 行，包含 n 个数字表示排列
 * A，其中等于0的项表示看不清的位置（不超过 10 个）。
 * 
 * 输出描述:
 * 
 * 输出一行表示合法的排列数目。
 */
public class T08数列还原 {
	private static int res = 0;
	private static ArrayList<Integer> fuzzyNum = new ArrayList<Integer>();
	private static ArrayList<ArrayList<Integer>> store = new ArrayList<ArrayList<Integer>>();
	private static int clearOrderCount = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), k = in.nextInt();
		int[] array = new int[n];
		// 缺失的位置
		ArrayList<Integer> fuzzyPos = new ArrayList<Integer>();
		boolean[] flag = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
			flag[array[i]] = (array[i] != 0);
			if (array[i] == 0)
				fuzzyPos.add(array[i]);
		}
		for (int i = 0; i < n; i++)
			if (array[i] != 0)
				for (int j = i; j < n; j++)
					if (array[j] != 0 && array[i] < array[j])
						clearOrderCount++;
		// 缺失的数字
		System.out.println("clearOrderCount = " + clearOrderCount);
		for (int i = 1; i < flag.length; i++)
			if (!flag[i])
				fuzzyNum.add(i);
		// 接下来全排列
		arrangeHelper(fuzzyPos, 0, k, array);
		System.out.println(res);
	}

	public static void arrangeHelper(ArrayList<Integer> fuzzyPos, int i, int k, int[] array) {
		if (!store.contains(fuzzyPos)) {
			store.add(fuzzyPos);
			if (orderCount(fuzzyPos, array) == k - clearOrderCount)
				res++;
		}
		for (int j = i; j < fuzzyPos.size(); j++) {
			Collections.swap(fuzzyPos, i, j);
			arrangeHelper(fuzzyPos, i + 1, k, array);
			Collections.swap(fuzzyPos, j, i);
		}
	}

	public static int orderCount(ArrayList<Integer> fuzzyPos, int[] array) {
		int res = 0;
		for (int i = 0; i < fuzzyPos.size(); i++)
			array[fuzzyPos.get(i)] = fuzzyNum.get(i);
		for (int i = 0; i < fuzzyPos.size(); i++)
			for (int j = fuzzyPos.get(i) + 1; j < array.length; j++)
				if (array[j] > array[i])
					res++;
		return res;
	}

}
