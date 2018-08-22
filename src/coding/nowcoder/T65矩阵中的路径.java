package coding.nowcoder;

/*
 * ��Ŀ���� �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ� ���� a b c e s f c s a d e e
 * �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
 */
public class T65�����е�·�� {
	/**
	 * ��һ��״̬���鱣��֮ǰ���ʹ����ַ���Ȼ���ٷֱ��ϣ��£����ҵݹ�
	 */
	public class Solution {
		public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
			int flag[] = new int[matrix.length];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (helper(matrix, rows, cols, i, j, str, 0, flag))
						return true;
				}
			}
			return false;
		}

		private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
			int index = i * cols + j;
			if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
				return false;
			if (k == str.length - 1)
				return true;
			flag[index] = 1;
			if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag) || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag) || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag) || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
				return true;
			}
			flag[index] = 0;
			return false;
		}
	}
}
