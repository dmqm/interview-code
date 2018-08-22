package coding.recruit17;

import java.util.Scanner;

/*
 * 题目描述 一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3 输入描述:
 * 
 * 输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。
 * 
 * 输出描述:
 * 
 * 所有连续子数组中和最大的值。
 */
public class T29连续最大和 {
	// 比动态规划简单的，不断累加，只要小于0，清零，重新开始，只需要记录过程中的最大值
	public static class Main {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int[] arr = new int[n];
			int m = n, i = 0;
			while (m-- > 0) {
				arr[i++] = sc.nextInt();
			}
			int maxSoFar = Integer.MIN_VALUE, maxCur = 0;
			for (i = 0; i < n; i++) {
				maxCur = Math.max(maxCur + arr[i], arr[i]);
				maxSoFar = Math.max(maxCur, maxSoFar);
			}
			System.out.println(maxSoFar);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int[] src = new int[n];
			for (int i = 0; i < n; i++)
				src[i] = in.nextInt();
			long[] f = new long[n];
			f[0] = src[0];
			long max = f[0];
			for (int i = 1; i < n; i++) {
				if (f[i - 1] > 0)
					f[i] = src[i] + f[i - 1];
				else
					f[i] = src[i];
				if (f[i] > max)
					max = f[i];
			}
			System.out.println(max);
		}
	}

}
