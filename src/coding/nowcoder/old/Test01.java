package coding.nowcoder.old;


import java.util.Scanner;

/*
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Test01 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	}

	public static class Solution {
		public static boolean Find(int target, int[][] array) {
			int rows = array.length, lines = array[0].length;
			for (int i = 0, j = lines - 1; i < rows && j >= 0;) {
				if (array[i][j] == target)
					return true;
				else if (array[i][j] > target)
					j--;
				else
					i++;
			}
			return false;
		}
	}

}
