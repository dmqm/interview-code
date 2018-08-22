package coding.nowcoder;

/*
 * ��Ŀ���� ͳ��һ�����������������г��ֵĴ�����
 */
public class T37���������������г��ֵĴ��� {
	public class Solution {
		public int GetNumberOfK(int[] array, int k) {
			// ÿ���������
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
