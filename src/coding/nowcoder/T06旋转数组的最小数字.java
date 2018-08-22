package coding.nowcoder;

/*
 * 题目描述 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class T06旋转数组的最小数字 {
	public class Solution {
		public int minNumberInRotateArray(int[] array) {
			if (array.length == 0)
				return 0;
			if (array.length == 1)
				return array[1];
			for (int i = 0; i < array.length - 1;) {
				if (array[i] > array[++i])
					return array[i];
			}
			return array[1];
		}
	}
	public class Solution2 {
		public int minNumberInRotateArray(int[] array) {
			if (array == null || array.length == 0)
				return 0;
			int start = 0;
			int end = array.length - 1;
			int mid = (start + end) / 2;
			if (array[end] == array[start] || array[mid] == array[end] || array[mid] == array[start]) {
				return findMin(array);
			}
			if (array[mid] > array[start] && array[mid] < array[end]) {
				return array[0];
			}
			while (true) {
				mid = (start + end) / 2;
				if (array[mid] > array[start]) {
					start = mid;
				} else if (array[mid] < array[end]) {
					end = mid;
				}
				if ((start + 1) == end)
					break;
			}
			return array[end];
		}

		public int findMin(int[] array) {
			int result = Integer.MAX_VALUE;
			for (int i = 0; i <= array.length - 1; i++) {
				result = Math.min(result, array[i]);
			}
			return result;
		}
	}
}
