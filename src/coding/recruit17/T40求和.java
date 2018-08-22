package coding.recruit17;


import java.util.ArrayList;
/*
 * 题目描述 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来 输入描述:
 * 
 * 每个测试输入包含2个整数,n和m
 * 
 * 输出描述:
 * 
 * 按每个组合的字典序排列输出,每行输出一种组合
 * 
 * 示例1 输入 复制
 * 
 * 5 5
 * 
 * 输出 复制
 * 
 * 1 4 2 3 5
 * 
 * 
 */
import java.util.Scanner;

public class T40求和 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		// n结尾和为m的情况数
		// int[][] dp = new int[n + 1][m + 1];
		// dp[1][1] = 1;
		// DFS
	}

	// 只适合两个数相加
	public static void main0(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int high = n, low = 1;
		StringBuilder sb = new StringBuilder();
		while (high > low) {
			if (low + high == m) {
				sb.append(low + " " + high + "\n");
				low++;
			} else if (high + low > m) {
				high--;
			} else {
				low++;
			}
		}
		if (m <= n) {
			sb.append(m + "\n");
		}
		System.out.print(sb);
	}

	public static class Main1 {
		static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		static ArrayList<Integer> list = new ArrayList<>();

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n, m;

			while (sc.hasNext()) {
				n = sc.nextInt();
				m = sc.nextInt();
				dfs(1, m, n);
				for (ArrayList<Integer> l : res) {
					int i = 0;
					for (; i < l.size() - 1; i++) {
						System.out.print(l.get(i) + " ");
					}
					System.out.println(l.get(i));
				}
			}
		}

		public static void dfs(int index, int count, int n) {
			if (count == 0) {
				res.add(new ArrayList<>(list));
			} else {
				for (int i = index; i <= count && i <= n; i++) {
					list.add(i);
					dfs(i + 1, count - i, n);
					list.remove(list.size() - 1);
				}
			}
		}
	}
}
