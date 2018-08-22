package coding.nowcoder;

/*
 * ��Ŀ���� ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 */
public class T01��ά����Ĳ��� {

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
