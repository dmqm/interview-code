package coding.nowcoder.old;
import java.util.ArrayList;

/*
 * ��Ŀ����
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100�����������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��û���,
 * ���͵õ���һ������������Ϊ100������:18,19,20,21,22�����ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck! �������:
 * 
 * ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
 */

public class Test42 {
	public class Solution {
		public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
			ArrayList<Integer> div = new ArrayList<Integer>();
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			return res;
		}
	}
	public class Solution2 {
		public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
			ArrayList<Integer> div = new ArrayList<Integer>();
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			if (sum < 3)
				return res;
			for (int i = 1; i < Math.sqrt(2 * sum); i++) {
				if (sum % i == 0)
					div.add(i);
			}
			Integer s;
			for (Integer i : div) {
				s = sum / i;
				if (sum % 2 == 1) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for (int j = s / 2 - i + 1; j <= s / 2 + i; j++)
						temp.add(j);
					res.add(temp);
					continue;
				}
				if (i % 2 == 1) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for (int j = s - i / 2; j <= s + i / 2; j++)
						temp.add(j);
					res.add(temp);
					continue;
				}


			}
			return res;
		}
	}
}
