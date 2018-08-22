package coding.nowcoder;

/*
 * 题目描述 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class T12数值的整数次方 {
	public class Solution {
		public double Power(double base, int exponent) {
			double res = 1, old = base;
			boolean flag = false;
			if (exponent == 0)
				return 1;
			if (exponent < 0) {
				exponent = -exponent;
				flag = true;
			}
			while (exponent != 0) {
				res *= (exponent & 1) * old;
				old *= old;
				exponent >>= 1;
			}
			return flag ? 1 / res : res;
		}
	}
}
