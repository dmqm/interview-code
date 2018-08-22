package coding.recruit17;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 题目描述 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3....... 这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的
 * 石板，小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。
 * 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。 例如： N = 4，M = 24： 4->6->8->12->18->24
 * 于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板 输入描述:
 * 
 * 输入为一行，有两个整数N，M，以空格隔开。 (4 ≤ N ≤ 100000) (N ≤ M ≤ 100000)
 * 
 * 输出描述:
 * 
 * 输出小易最少需要跳跃的步数,如果不能到达输出-1
 */
public class T23跳石板 {
	// 别人的方法，动态规划
	public static class Main {
		public static int deal(int m, int n) {// m到n
			int mark[] = new int[n + 1];// 记录到达每一个位置的步数
			for (int i = m + 1; i <= n; i++) { // 初始化
				mark[i] = Integer.MAX_VALUE;
			}
			for (int i = m; i < n - 1; i++) { // 填mark[]
				if (mark[i] == Integer.MAX_VALUE)
					continue; // 如果当前起始位置本身不可达 不作处理
				ArrayList<Integer> list = allFactor(i); // 获得当前位置i的所有因子
				for (int j = 0; j < list.size(); j++) { // 计算i能到达的每一个位置tmp
					int tmp = i + list.get(j);
					int count = mark[i] + 1;
					if (tmp <= n && mark[tmp] > count) { // 如果从i到达位置tmp的次数比以前记录的小 更新mark[tmp]
						mark[tmp] = count;
					}
				}
			}
			return mark[n];
		}

		public static ArrayList<Integer> allFactor(int n) {// 获得n的所有因子 除1 n外
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					list.add(i);
					if (i != n / i)
						list.add(n / i);
				}
			}
			return list;
		}

		public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);
			int m = sc.nextInt();
			int n = sc.nextInt();
			int r = deal(m, n);
			if (r == Integer.MAX_VALUE)
				r = -1;
			System.out.println(r);
		}
	}

	// 思路不清晰啊……,贪心算法
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int M = in.nextInt();
			System.out.println(getDesHelper(N, M));;
		}
	}

	public static int getDesHelper(int n, int m) {
		if (m < n || getMaxDiv(n) == 1 || getMaxDiv(n, m) == 1)
			return -1;
		int res = 0;
		while (n != m) {
			if (n == getMaxDiv(n, m))
				n += getMaxDiv(n);
			else
				n += getMaxDiv(n, m);
			res++;
		}
		return res;
	}

	// 默认m>n
	public static int getMaxDiv(int n, int m) {
		int t = m % n;
		while (t != 0) {
			m = n;
			n = t;
			t = m % n;
		}
		return n;
	}

	public static int getMaxDiv(int n) {
		for (int i = n - 1; i > 1; i--)
			if (n % i == 0)
				return i;
		return 1;
	}
}
