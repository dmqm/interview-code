package coding.recruit17;

import java.util.Scanner;

/*
 * 题目描述 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，使得这 k
 * 个学生的能力值的乘积最大，你能返回最大的乘积吗？ 输入描述:
 * 
 * 每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <=
 * ai <= 50）。接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
 * 
 * 输出描述:
 * 
 * 输出一行表示最大的乘积。
 */
public class T01合唱团 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ai = new int[n];
		for (int i = 0; i < n; i++)
			ai[i] = in.nextInt();
		int k = in.nextInt(), d = in.nextInt();
		long[][] min = new long[n][k], max = new long[n][k];
		for (int i = 0; i < n; i++) {
			min[i][0] = ai[i];
			max[i][0] = ai[i];
		}
		// 自低向上递推
		// f[j][i]表示选择i+1个学生，且最后一个学生是第j+1个
		for (int kk = 1; kk < k; kk++)
			for (int nn = kk; nn < n; nn++) {
				long MAX = Long.MIN_VALUE;
				long MIN = Long.MAX_VALUE;
				for (int l = Math.max(nn - d - 1, kk - 1); l < nn - 1; l++) {
					if (MAX < Math.max(max[l][kk - 1] * ai[nn], min[l][kk - 1] * ai[nn]))
						MAX = Math.max(max[l][kk - 1] * ai[nn], min[l][kk - 1] * ai[nn]);
					if (MIN > Math.min(max[l][kk - 1] * ai[nn], min[l][kk - 1] * ai[nn]))
						MIN = Math.min(max[l][kk - 1] * ai[nn], min[l][kk - 1] * ai[nn]);
				}
				max[nn][kk] = MAX;
				min[nn][kk] = MIN;
			}
		long res = Long.MIN_VALUE;
		for (int i = k - 1; i < n; i++)
			res = (res > max[i][k - 1]) ? res : max[i][k - 1];
		System.out.println(res);
	}
}
