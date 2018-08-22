package coding.nowcoder;

import java.util.ArrayList;

/*
 * ��Ŀ���� ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class T19˳ʱ���ӡ���� {
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
