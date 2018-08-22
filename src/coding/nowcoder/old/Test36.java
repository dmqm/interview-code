package coding.nowcoder.old;

/*
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007 题目保证输入的数组中没有的相同的数字
 * 
 * 数据范围：
 * 
 * 对于%50的数据,size<=10^4
 * 
 * 对于%75的数据,size<=10^5
 * 
 * 对于%100的数据,size<=2*10^5
 */
// 归并排序……
public class Test36 {
	public class Solution {
		public int InversePairs(int[] array) {
			int res = 0;
			if (null == array || array.length <= 1)
				return res;
			int[] copy = new int[array.length];
			res = getCount(0, array.length - 1, array, copy);
			return res;
		}

		private int getCount(int low, int high, int[] array, int[] copy) {
			if (low >= high)
				return 0;
			int res = 0;
			int mid = (low + high) >> 1;
			int leftCount = getCount(low, mid, array, copy) % 1000000007;
			int rightCount = getCount(mid + 1, high, array, copy) % 1000000007;
			int copyIndex = high;
			int left=mid,right=high;
			while (left >= low && right >= mid + 1)
				if (array[left] > array[right]) {
					copy[copyIndex--] = array[left--];
					res = (res + right - mid) % 1000000007;
				}
				else {
					copy[copyIndex--] = array[right--];
				}
			while (left >= low)
				copy[copyIndex--] = array[left--];
			while (right >= mid + 1)
				copy[copyIndex--] = array[right--];
			for (int i = low; i <= high; i++)
				array[i] = copy[i];
			return (res + leftCount + rightCount) % 1000000007;
					
		}
	}
	// 暴力破解貌似超时
	public class Solution2 {
		public int InversePairs(int[] array) {
			int res = 0;
			for (int i = 0; i < array.length; i++) {
				for (int j = i + 1; j < array.length; j++)
					if (array[j] < array[i])
						res++;
			}
			return res;

		}
	}
}
