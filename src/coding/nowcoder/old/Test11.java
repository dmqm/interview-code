package coding.nowcoder.old;
// ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
public class Test11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
		public int NumberOf1(int n) {
			int res = 0;
			if (n > 0) {
				while (n != 0) {
					res += (n & 1);
					n >>= 1;
				}
			} else if (n < 0) {
				// -127�Ķ������� 10000001��011111111 - ��ȡ�����ټ�1 ->10000000+1 = 10000001��
				n = n & 0x7FFFFFFF;
				res++;
				while (n != 0) {
					res += (n & 1);
					n >>= 1;
				}
			} else
				return 0;
			return res;

		}
	}
}
