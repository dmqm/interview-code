package coding.nowcoder.old;
import java.util.ArrayList;

// һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
public class Test41 {
	// num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
	// ��num1[0],num2[0]����Ϊ���ؽ��
	public class Solution {
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
