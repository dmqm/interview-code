package coding.nowcoder;

import java.util.ArrayList;

/*
 * 题目描述 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。 输出描述:
 * 
 * 对应每个测试案例，输出两个数，小的先输出。
 * 
 */
public class T42和为S的两个数字 {
	public class Solution {
		public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
			int left = 0, right = array.length - 1, temp;
			ArrayList<Integer> res = new ArrayList<Integer>();
			while (left < right) {
				temp = array[left] + array[right];
				if (temp > sum)
					right--;
				else if (temp < sum)
					left++;
				else if (temp == sum) {
					res.add(array[left]);
					res.add(array[right]);
					left = right;
				}
			}
			return res;
		}
	}
}
