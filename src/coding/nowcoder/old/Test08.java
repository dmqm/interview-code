package coding.nowcoder.old;
// 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
public class Test08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
		public int JumpFloor(int target) {
			if (target <= 2)
				return target;
			int res = 2;
			int old = 1, temp;
			for (int i = 2; i < target; i++) {
				temp = res;
				res = res + old;
				old = temp;
			}
			return res;
		}
	}
}
