package coding.nowcoder.old;


import java.util.Scanner;

/*
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
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
