package coding.nowcoder.old;
// 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
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
				// -127的二进制是 10000001（011111111 - 先取反，再加1 ->10000000+1 = 10000001）
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
