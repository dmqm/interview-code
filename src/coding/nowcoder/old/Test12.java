package coding.nowcoder.old;
// 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
public class Test12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
		public double Power(double base, int exponent) {
			double res = 1, old = base;
			boolean flag = false;
			if (exponent < 0) {
				exponent = -exponent;
				flag=true;
			}
			while (exponent != 0) {
				res*=(exponent&1)*old;
				old*=old;
				exponent >>>= 1;
			}
			return flag ? 1 / res : res;

		}
	}

}
