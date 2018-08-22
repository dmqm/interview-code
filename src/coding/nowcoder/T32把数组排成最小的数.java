package coding.nowcoder;

/*
 * ��Ŀ���� ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 */
import java.util.ArrayList;
import java.util.Comparator;

public class T32�������ų���С���� {
	public class Solution {
		public String PrintMinNumber(int[] numbers) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < numbers.length; i++)
				list.add(numbers[i]);
			list.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer T1, Integer T2) {
					String a = T1.toString();
					String b = T2.toString();
					return (a + b).compareTo(b + a);
				}
			});
			StringBuilder ans = new StringBuilder();
			for (int i = 0; i < numbers.length; i++)
				ans.append(list.get(i));
			return ans.toString();
		}
	}
}
