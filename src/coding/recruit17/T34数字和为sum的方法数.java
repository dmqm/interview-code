package coding.recruit17;


import java.util.Arrays;
import java.util.Scanner;

/*
 * 题目描述 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。 输入描述:
 * 
 * 输入为两行: 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000) 第二行为n个正整数A[i](32位整数)，以空格隔开。
 * 
 * 输出描述:
 * 
 * 输出所求的方案数
 */
public class T34数字和为sum的方法数 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int sum = in.nextInt();
			int[] A = new int[n];
			for (int i = 0; i < n; i++) {
				A[i] = in.nextInt();
			}
			int res = 0;
			Arrays.sort(A);
			// 2^n暴力方法
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			int sum = in.nextInt();
			int[] value = new int[n];
			long[] dp = new long[sum + 1];
			dp[0] = 1;
			for (int i = 0; i < n; i++) {
				value[i] = in.nextInt();
				for (int j = sum; j >= 0; j--) {
					if (j >= value[i]) {
						dp[j] += dp[j - value[i]];
					}
				}
			}
			System.out.println(dp[sum]);
		}
	}
}
