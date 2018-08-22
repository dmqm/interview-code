package coding.recruit17;

import java.util.Scanner;

/*
 * 题目描述 牛牛和 15 个朋友来玩打土豪分田地的游戏，牛牛决定让你来分田地，地主的田地可以看成是一个矩形，每个位置有一个价值。分割田地的方法是横竖各切三刀，分成 16
 * 份，作为领导干部，牛牛总是会选择其中总价值最小的一份田地， 作为牛牛最好的朋友，你希望牛牛取得的田地的价值和尽可能大，你知道这个值最大可以是多少吗？ 输入描述:
 * 
 * 每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 75），表示田地的大小，接下来的 n 行，每行包含 m 个 0-9
 * 之间的数字，表示每块位置的价值。
 * 
 * 输出描述:
 * 
 * 输出一行表示牛牛所能取得的最大的价值。
 */
public class T04分田地 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x1 = 0; // 代表横方向3刀
		int x2 = 0;
		int x3 = 0;
		int y1 = 0; // 代表纵方向3刀
		int y2 = 0;
		int y3 = 0;
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				String string = scanner.next();
				for (int j = 0; j < m; j++) {
					arr[i][j] = string.charAt(j) - '0';
				}
			}
			int[][] sum = new int[n + 1][m + 1];
			// sum[i][j]表示左上顶点arr[0][0]到右下顶点arr[i-1][j-1]的矩阵元素的和
			// sum[1][1]表示arr[0][0]
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < m + 1; j++) {
					sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i - 1][j - 1]; // 该公式已验证，正确
				}
			}
			int left = 0;
			int right = sum[n][m];
			int res = 0;

			while (left <= right) {
				int mid = (left + right) / 2;
				if (judge(mid, n, m, sum)) {
					left = mid + 1;
					res = mid;
				} else {
					right = mid - 1;
				}
			}
			System.out.println(res);
		}
		scanner.close();
	}

	// 计算arr矩阵中左上定点(i,j)到右下顶点(x-1,y-1)确定的田地的价值和
	public static int cal(int x, int y, int i, int j, int[][] sum) {
		return sum[x][y] - sum[x][j] - sum[i][y] + sum[i][j];
	}

	// 判断x是否<=田地中最小一块的值
	public static boolean judge(int x, int n, int m, int[][] sum) {
		for (int i = 1; i <= m - 3; i++) {
			for (int j = i + 1; j <= m - 2; j++) {
				for (int k = j + 1; k <= m - 1; k++) {
					int last = 0;
					int cnt = 0;
					for (int r = 1; r <= n; r++) {
						int s1 = cal(r, i, last, 0, sum);
						int s2 = cal(r, j, last, i, sum);
						int s3 = cal(r, k, last, j, sum);
						int s4 = cal(r, m, last, k, sum);
						// 当前横切一刀条件满足
						if (s1 >= x && s2 >= x && s3 >= x && s4 >= x) {
							last = r;
							cnt++;
						}
					}
					// 表明x小于等于16块田地中的最小值，返回true
					if (cnt >= 4) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
