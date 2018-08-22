package coding.recruit17;


import java.util.ArrayList;
/*
 * ��Ŀ���� ������������ n �� m��������1��2��3.......n ������ȡ������,ʹ��͵��� m ,Ҫ���������еĿ�������г��� ��������:
 * 
 * ÿ�������������2������,n��m
 * 
 * �������:
 * 
 * ��ÿ����ϵ��ֵ����������,ÿ�����һ�����
 * 
 * ʾ��1 ���� ����
 * 
 * 5 5
 * 
 * ��� ����
 * 
 * 1 4 2 3 5
 * 
 * 
 */
import java.util.Scanner;

public class T40��� {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		// n��β��Ϊm�������
		// int[][] dp = new int[n + 1][m + 1];
		// dp[1][1] = 1;
		// DFS
	}

	// ֻ�ʺ����������
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
