package coding.nowcoder;

/*
 * 题目描述 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0 输入描述:
 * 
 * 输入一个字符串,包括数字字母符号,可以为空
 * 
 * 输出描述:
 * 
 * 如果是合法的数值表达则返回该数字，否则返回0
 */
public class T49把字符串转换成整数 {
	public class Solution {
		public int StrToInt(String str) {
			int res = 0;
			int temp, i = 0;
			boolean signal = true;
			if (str.length() == 0)
				return 0;
			if (str.charAt(0) == '+') {
				i++;
			}
			if (str.charAt(0) == '-') {
				i++;
				signal = false;
			}
			for (; i < str.length(); i++) {
				temp = str.charAt(i) - '0';
				if (temp < 0 || temp > 9)
					return 0;
				res = res << 1 + res << 3 + temp;
			}
			return signal ? res : -res;
		}
	}
}
