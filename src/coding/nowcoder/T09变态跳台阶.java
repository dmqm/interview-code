package coding.nowcoder;

/*
 * 题目描述 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class T09变态跳台阶 {
	public class Solution {
		public int JumpFloorII(int target) {

			if (target <= 2)
				return target;
			int res = 2;
			for (int i = 2; i < target; i++) {
				res <<= 1;
			}
			return res;


		}
	}
}
