package coding.nowcoder;

/*
 * ��Ŀ���� ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�
 * 
 * n<=39
 */
public class T07쳲��������� {
	public class Solution {
		public int Fibonacci(int n) {
			if (n == 0)
				return 0;
			if (n == 1 || n == 2)
				return 1;
			int res = 1;
			int old = 1, temp;
			for (int i = 2; i < n; i++) {
				temp = res;
				res = res + old;
				old = temp;
			}
			return res;
		}
	}
}
