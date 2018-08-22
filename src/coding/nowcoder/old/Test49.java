package coding.nowcoder.old;
/* 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。 */
public class Test49 {
	public class Solution {
		public int Add(int num1, int num2) {
			while (num2 != 0) {// 进位为0停止
				int temp = num1 ^ num2;// 相加
				num2 = (num1 & num2) << 1;// 进位
				num1 = temp;
			}
			return num1;
		}
	}
	public class Solution2 {
		public int Add(int num1, int num2) {
			return Math.addExact(num1, num2);
		}
	}
}
