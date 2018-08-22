package coding.nowcoder;

import java.util.ArrayList;

/*
 * ��Ŀ���� һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 */
public class T40������ֻ����һ�ε����� {
	// num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
	// ��num1[0],num2[0]����Ϊ���ؽ��
	public class Solution {
		/*
		 * ���ȣ�λ�������������ʣ�������ͬ�������=0��һ������0�����������
		 * ��ֻ��һ��������һ��ʱ�����ǰ����������е���������������㣬���ʣ�µľ����䵥��������Ϊ�ɶԶ����ֵĶ������ˡ�
		 * �������˼·���������������������Ǽ�����AB������һ�ε����顣�������Ȼ��������ʣ�µ����ֿ϶���A��B���Ľ�����������Ķ������е�1�����ֵ���A��B�Ĳ�ͬ��λ��
		 * ���Ǿ�ȡ��һ��1���ڵ�λ���������ǵ�3λ�����Ű�ԭ����ֳ����飬�����׼�ǵ�3λ�Ƿ�Ϊ1����ˣ���ͬ�����϶���һ���飬��Ϊ��ͬ��������λ����ͬ������ͬ�������϶�����һ�顣
		 * Ȼ����������鰴���ʼ��˼·���������ʣ��������������������ֻ����һ�ε����֡�
		 */
		public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
			int length = array.length;
			if (length == 2) {
				num1[0] = array[0];
				num2[0] = array[1];
				return;
			}
			int bitResult = 0;
			for (int i = 0; i < length; ++i) {
				bitResult ^= array[i];
			}
			int index = findFirst1(bitResult);
			for (int i = 0; i < length; ++i) {
				if (isBit1(array[i], index)) {
					num1[0] ^= array[i];
				} else {
					num2[0] ^= array[i];
				}
			}
		}

		private int findFirst1(int bitResult) {
			int index = 0;
			while (((bitResult & 1) == 0) && index < 32) {
				bitResult >>= 1;
				index++;
			}
			return index;
		}

		private boolean isBit1(int target, int index) {
			return ((target >> index) & 1) == 1;
		}
	}
	public class Solution2 {
		public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

			if (array.length < 2)
				return;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < array.length; i++) {
				if (list.contains(array[i]))
					list.remove((Integer) array[i]);
				else
					list.add(array[i]);
			}
			num1[0] = list.get(0);
			num2[0] = list.get(1);

		}
	}
}
