package coding.nowcoder.old;

import java.util.Stack;

/*
 * 题目描述 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Test66 {
	public class Solution {
		public int movingCount(int threshold, int rows, int cols) {
			int flag[][] = new int[rows][cols]; // 记录是否已经走过
			return helper(0, 0, rows, cols, flag, threshold);
		}

		private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
			if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1)
				return 0;
			flag[i][j] = 1;
			return helper(i - 1, j, rows, cols, flag, threshold) + helper(i + 1, j, rows, cols, flag, threshold) + helper(i, j - 1, rows, cols, flag, threshold) + helper(i, j + 1, rows, cols, flag, threshold) + 1;
		}

		private int numSum(int i) {
			int sum = 0;
			do {
				sum += i % 10;
			} while ((i = i / 10) > 0);
			return sum;
		}
	}
	public class Solution2 {
		public int movingCount(int threshold, int rows, int cols) {
			Stack<Point> s = new Stack<Point>();
			boolean[][] flag = new boolean[rows][cols];
			for (boolean b[] : flag)
				for (boolean bool : b)
					bool = false;
			int res = 1;
			flag[0][0] = true;
			s.push(new Point(0, 0));
			while (!s.isEmpty()) {
				Point p = s.pop();
				int x = p.x, y = p.y;
				if (x + 1 < cols && !flag[x + 1][y]) {
					if (num(x + 1) + num(y) <= threshold) {
						res++;
						s.push(new Point(x + 1, y));
					}
				}
				if (y + 1 < rows && !flag[x][y + 1]) {
					if (num(x) + num(y + 1) <= threshold) {
						res++;
						s.push(new Point(x, y + 1));
					}
				}
			}
			return res;
		}

		int num(int i) {
			int res = 0;
			while (i % 10 != 0) {
				res += i % 10;
				i /= 10;
			}
			return res;
		}

		public class Point {
			int x;
			int y;

			Point(int x, int y) {
				this.x = x;
				this.y = y;
			}


		}
	}
}
