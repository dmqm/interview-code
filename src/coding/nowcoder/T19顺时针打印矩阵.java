package coding.nowcoder;

import java.util.ArrayList;

/*
 * 题目描述 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class T19顺时针打印矩阵 {
	public class Solution {
		public ArrayList<Integer> printMatrix(int[][] matrix) {
			ArrayList<Integer> des = new ArrayList<Integer>();
			int topX = 0, topY = 0, bottomX = matrix[0].length - 1, bottomY = matrix.length - 1;
			while (topX <= bottomX && topY <= bottomY) {
				for (int i = topX; i <= bottomX; i++)
					des.add(matrix[topY][i]);
				for (int i = topY + 1; i <= bottomY; i++)
					des.add(matrix[i][bottomX]);
				if (topY != bottomY)
					for (int i = bottomX - 1; i >= topX; i--)
						des.add(matrix[bottomY][i]);
				if (topX != bottomX)
					for (int i = bottomY - 1; i > topY; i--)
						des.add(matrix[i][topX]);
				topX++;
				topY++;
				bottomX--;
				bottomY--;
			}
			return des;
		}
	}
}
