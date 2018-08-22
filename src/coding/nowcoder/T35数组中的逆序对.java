package coding.nowcoder;

/*
 * ��Ŀ���� �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ�������
 * �����P%1000000007 ��������:
 * 
 * ��Ŀ��֤�����������û�е���ͬ������
 * 
 * ���ݷ�Χ��
 * 
 * ����%50������,size<=10^4
 * 
 * ����%75������,size<=10^5
 * 
 * ����%100������,size<=2*10^5
 */
public class T35�����е������ {
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
			int left = mid, right = high;
			while (left >= low && right >= mid + 1)
				if (array[left] > array[right]) {
					copy[copyIndex--] = array[left--];
					res = (res + right - mid) % 1000000007;
				} else {
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
}
