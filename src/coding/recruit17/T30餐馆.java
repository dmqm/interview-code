package coding.recruit17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 题目描述 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
 * 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大 输入描述:
 * 
 * 输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000)
 * 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。
 * 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
 * 
 * 输出描述:
 * 
 * 输出一个整数,表示最大的总预计消费金额
 */
public class T30餐馆 {
	// 最优化问题,完全不会啊
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt(), m = in.nextInt();
			int[] cap = new int[n];
			for (int i = 0; i < n; i++)
				cap[i] = in.nextInt();
			int[][] cus = new int[m][2];
			for (int i = 0; i < m; i++) {
				cus[i][0] = in.nextInt();
				cus[i][1] = in.nextInt();
			}
			long res = 0;
		}
	}

	/*
	 * 别人的， 基本思路就是：桌子序列升序排列
	 * 客人按照预定花钱多少降序排序，然后贪心法从钱多的客人开始招呼。但是这题时间复杂度卡得太紧，在遍历能容得下第i批客人的时候需要二分查找去找否则超时，以下是我的代码
	 */
	public static class Main {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			while (sc.hasNext()) {
				int n = sc.nextInt(); // n table
				int m = sc.nextInt(); // m customers
				int[] table = new int[n];
				for (int i = 0; i < n; i++)
					table[i] = sc.nextInt(); // volume of a table

				int[][] cus = new int[m][2];
				for (int j = 0; j < m; j++) {
					cus[j][0] = sc.nextInt(); // number of customers
					cus[j][1] = sc.nextInt(); // money
				}

				Arrays.sort(table);
				Arrays.sort(cus, new Comparator<int[]>() {

					@Override
					public int compare(int[] a, int[] b) {

						return b[1] - a[1];

					}
				});

				long res = 0L;
				int index = 0;
				boolean[] tableb = new boolean[n];
				for (int i = 0; i < m; i++) {
					if (cus[i][0] > table[n - 1])
						continue;
					index = bs(table, cus[i][0]);
					while (index < n && tableb[index] == true)
						index++;
					if (index < n) {
						res += cus[i][1];
						tableb[index] = true;
					}
				}

				System.out.println(res);
			}
			sc.close();
		}

		private static int bs(int[] num, int tar) {
			int low = 0;
			int high = num.length - 1;
			int mid = 0;
			while (low <= high) {
				mid = (high + low) >> 1;
				if (num[mid] >= tar)
					high = mid - 1;
				else
					low = mid + 1;
			}

			return low;
		}
	}
}
