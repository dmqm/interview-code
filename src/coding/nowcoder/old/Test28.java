package coding.nowcoder.old;
// 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
public class Test28 {
	public class Solution {
		public int MoreThanHalfNum_Solution(int[] array) {
			if (array.length == 0)
				return 0;
			if (array.length == 1)
				return array[0];
			int num = array[0], count = 1;
			for (int i = 1; i < array.length; i++) {
				if (count == 0)
					num = array[i];
				if (array[i] == num)
					count++;
				else
					count--;
			}
			count = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] == num)
					count++;
			}
			if (count * 2 > array.length)
				return num;
			return 0;
		}
	}
}
