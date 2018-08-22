package coding.nowcoder;

/*
 * 题目描述 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class T01二维数组的查找 {

	public class Solution {
		public boolean Find(int target, int[][] array) {
			if (null == array)
				return false;
			int rows = array.length;
			int cols = array[0].length;
			for (int i = 0, j = cols - 1; i < rows && j >= 0;) {
				if (target < array[i][j])
					j--;
				else if (target > array[i][j])
					i++;
				else
					return true;
			}
			return false;
		}
	}
}
