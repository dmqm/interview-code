package coding.nowcoder.old;
import java.util.ArrayList;

// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
// 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
public class Test19 {
	public class Solution {
		public ArrayList<Integer> printMatrix(int[][] matrix) {
			// Matrix
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
	// 有问题……
	public class Solution1 {
		public ArrayList<Integer> printMatrix(int[][] matrix) {
			int finalPosI = matrix.length / 2 + matrix.length % 2 - 1;
			int finalPosJ = matrix.length / 2 - matrix.length % 2;
			int stat = 0;// 0123右下左上
			int loop = 0;
			int len = matrix.length - 1;
			ArrayList<Integer> res = new ArrayList<Integer>();
			for (int i = 0, j = 0; i == finalPosI && j == finalPosJ;) {
				res.add(matrix[i][j]);
				switch (stat) {
					case 0:
						if (i < len - loop)
							i++;
						else if (i == len - loop) {
							stat = 1;
							j++;
						}
						break;
					case 1:
						if (j < len - loop)
							j++;
						else if (i == len - loop) {
							stat = 2;
							i--;
						}
						break;
					case 2:
						if (i > loop)
							i--;
						else if (i == loop) {
							stat = 3;
							j--;
						}
						break;
					case 3:
						if (j > loop)
							j++;
						else if (j == loop) {
							if (loop < finalPosI) {
								stat = 1;
								i++;
								loop++;
							}
						}
						break;
				}
			}
			return res;

		}
	}
}
