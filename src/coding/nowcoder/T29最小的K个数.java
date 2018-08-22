package coding.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * ��Ŀ���� ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 */
public class T29��С��K���� {
	public class Solution {
		public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			if (input == null || input.length == 0 || input.length < k) {
				return result;
			}
			// �����󶥶�
			for (int i = k / 2 - 1; i >= 0; i--) {
				adjustHeap(input, i, k - 1);
			}
			// ����ǰk��Ԫ�صĴ󶥶��Ѿ��������ˣ�ʣ�µľ�������ĺʹ󶥶ѵ����ֵ�Ƚ���
			for (int i = k; i < input.length; i++) {
				if (input[i] < input[0]) {
					int temp = input[i];
					input[i] = input[0];
					input[0] = temp;
					adjustHeap(input, 0, k - 1);
				}
			}
			// ���ǽ������õ�ǰk�����Ž���������
			for (int i = 0; i < k; i++) {
				result.add(input[i]);
			}
			return result;
		}

		// �����󶥶�,�������
		public void adjustHeap(int[] input, int i, int k) {
			// �Ȱ���������ڵ㱣����
			int temp = input[i];
			for (int j = i * 2 + 1; j <= k; j = j * 2 + 1) {
				// j���Ե���k����������ĳ����ܣ����ǻ�Ҫ�ж�j��j+1��
				if (j < k && input[j] < input[j + 1]) {
					j++;
				}
				if (temp > input[j]) {
					break;
				}
				input[i] = input[j];
				i = j;
			}
			input[i] = temp;
		}
	}
	public class Solution2 {
		public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
			ArrayList<Integer> des = new ArrayList<Integer>();
			if (input.length < k)
				return des;
			Arrays.sort(input);
			for (int i = 0; i < k; i++)
				des.add(input[i]);
			return des;
		}
	}
}
