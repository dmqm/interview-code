package coding.nowcoder.old;
// ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�
// n<=39
public class Test07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
