package coding.nowcoder.old;
// ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
public class Test28 {
	public class Solution {
		public int MoreThanHalfNum_Solution(int[] array) {
			if (array.length == 0)
				return 0;
			if (array.length == 1)
				return array[0];
			int num = array[0], count = 1;
			for (int i = 1; i < array.length; i++) {
				if (count == 0)
					num = array[i];
				if (array[i] == num)
					count++;
				else
					count--;
			}
			count = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] == num)
					count++;
			}
			if (count * 2 > array.length)
				return num;
			return 0;
		}
	}
}
