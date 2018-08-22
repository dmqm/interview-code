package coding.nowcoder;

/*
 * ��Ŀ���� ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */
public class T06��ת�������С���� {
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
