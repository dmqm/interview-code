package coding.nowcoder;

/*
 * ��Ŀ���� ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 */
public class T11��������1�ĸ��� {
	public class Solution {
		public int NumberOf1(int n) {
			int count = 0;
			while (n != 0) {
				++count;
				n = (n - 1) & n;
			}
			return count;
		}
	}
	public class Solution2 {
		public int NumberOf1(int n) {
			int count = 0;
			while (n != 0) {
				if ((n & 1) == 1)
					count++;
				n = n >>> 1;
			}
			return count;
		}
	}
}
