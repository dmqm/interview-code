package coding.nowcoder;

/*
 * 题目描述 统计一个数字在排序数组中出现的次数。
 */
public class T37数字在排序数组中出现的次数 {
	public class Solution {
		public int GetNumberOfK(int[] array, int k) {
			// 每次找最左边
			return GetNumberIndex(array, k + 1) - GetNumberIndex(array, k);
		}

		public int GetNumberIndex(int[] array, int k) {
			int low = 0, high = array.length, mid ;
			while (low < high) {
				mid = (low + high) / 2;
				if (array[mid] < k)
					low = mid + 1;
				else
					high = mid;
			}
			return high;
		}
	}
}
