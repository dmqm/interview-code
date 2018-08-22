package coding.nowcoder.old;
// 统计一个数字在排序数组中出现的次数。
public class Test38 {
	public class Solution {
		public int GetNumberOfK(int[] array, int k) {
			int left = 0, right = array.length - 1;
			boolean hasK = false;
			for (int i = left; i <= right; i++)
				if (array[i] == k) {
					left = i;
					hasK = true;
					break;
				}
			for (int i = right; i >= left; i--)
				if (array[i] == k) {
					right = i;
					break;
				}
			return hasK ? right - left + 1 : 0;
		}
	}
	public class Solution2 {
		public int GetNumberOfK(int[] array, int k) {
			return k;
		}
	}
}
