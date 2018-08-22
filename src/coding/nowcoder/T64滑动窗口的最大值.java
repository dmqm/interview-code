package coding.nowcoder;

/*
 * ��Ŀ����
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6
 * ,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6���� {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}��
 * {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 */
import java.util.ArrayList;

public class T64�������ڵ����ֵ {
	public class Solution {
		public ArrayList<Integer> maxInWindows(int[] num, int size) {
			int count = num.length - size, maxIndex;
			ArrayList<Integer> res = new ArrayList<Integer>();
			if (size == 0 || count < 0)
				return res;
			if (count == 0) {
				res.add(num[getMax(num, 0, num.length - 1)]);
				return res;
			}
			maxIndex = getMax(num, 0, size - 1);
			res.add(num[maxIndex]);
			for (int i = 1; i <= count; i++) {
				if (maxIndex != i - 1) {
					if (num[maxIndex] <= num[i + size - 1])
						maxIndex = i + size - 1;
					res.add(num[maxIndex]);
				} else {
					maxIndex = getMax(num, i, i + size - 1);
					res.add(num[maxIndex]);
				}
			}
			return res;
		}

		public int getMax(int[] num, int strIndex, int endIndex) {
			int index = strIndex;
			for (int i = strIndex + 1; i <= endIndex; i++)
				if (num[i] >= num[index])
					index = i;
			return index;
		}
	}
}
