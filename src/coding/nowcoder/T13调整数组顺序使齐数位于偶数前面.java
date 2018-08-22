package coding.nowcoder;

import java.util.ArrayList;
import java.util.List;

/*
 * 题目描述 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class T13调整数组顺序使齐数位于偶数前面 {
	public class Solution {
		public void reOrderArray(int[] array) {
			if (array.length == 0 || array.length == 1)
				return;
			int oddCount = 0, oddBegin = 0;
			int[] newArray = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				if ((array[i] & 1) == 1)
					oddCount++;
			}
			for (int i = 0; i < array.length; i++) {
				if ((array[i] & 1) == 1)
					newArray[oddBegin++] = array[i];
				else
					newArray[oddCount++] = array[i];
			}
			for (int i = 0; i < array.length; i++) {
				array[i] = newArray[i];
			}
		}
	}
	public class Solution1 {
		public void reOrderArray(int[] array) {
			List<Integer> ls1 = new ArrayList<Integer>();
			List<Integer> ls2 = new ArrayList<Integer>();
			for (int i = 0; i < array.length; i++) {
				if (array[i] % 2 == 1) {
					ls1.add(array[i]);
				} else {
					ls2.add(array[i]);
				}
			}
			ls1.addAll(ls2);
			for (int i = 0; i < array.length; i++) {
				array[i] = ls1.get(i);
			}
		}
	}
	public class Solution2 {
		public void reOrderArray(int[] array) {
			int index1 = 0, index2 = 0, temp;
			while (index2 < array.length) {
				if (array[index2] % 2 == 0)
					index2++;
				else {
					temp = array[index2];
					for (int i = index2; i > index1; i--)
						array[i] = array[i - 1];
					array[index1] = temp;
					index1++;
					index2++;
				}
			}
		}
	}
}
