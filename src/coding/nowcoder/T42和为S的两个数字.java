package coding.nowcoder;

import java.util.ArrayList;

/*
 * ��Ŀ���� ����һ����������������һ������S���������в������������ǵ����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ� �������:
 * 
 * ��Ӧÿ�����԰����������������С���������
 * 
 */
public class T42��ΪS���������� {
	public class Solution {
		public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
			int left = 0, right = array.length - 1, temp;
			ArrayList<Integer> res = new ArrayList<Integer>();
			while (left < right) {
				temp = array[left] + array[right];
				if (temp > sum)
					right--;
				else if (temp < sum)
					left++;
				else if (temp == sum) {
					res.add(array[left]);
					res.add(array[right]);
					left = right;
				}
			}
			return res;
		}
	}
}
