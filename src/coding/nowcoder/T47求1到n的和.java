package coding.nowcoder;

/*
 * 题目描述 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class T47求1到n的和 {
	public class Solution {
		public int Sum_Solution(int n) {
			int sum = n;
			boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
			return sum;
		}
	}
}
