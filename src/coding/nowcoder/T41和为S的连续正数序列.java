package coding.nowcoder;

import java.util.ArrayList;

/*
 * ��Ŀ����
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100�����������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��û���,
 * ���͵õ���һ������������Ϊ100������:18,19,20,21,22�����ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck! �������:
 * 
 * ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
 * 
 */
public class T41��ΪS�������������� {

	/*
	 * ������ѧ��ʽ����:(a1+an)*n/2=s n=an-a1+1
	 * 
	 * (an+a1)*(an-a1+1)=2*s=k*l(k>l)
	 * 
	 * an=(k+l-1)/2 a1=(k-l+1)/2
	 */
	public class Solution {
		public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			if (sum < 3)
				return list;
			int s = (int) Math.sqrt(2 * sum);
			for (int i = s; i >= 2; i--) {
				if (2 * sum % i == 0) {
					int d = 2 * sum / i;
					if (d % 2 == 0 && i % 2 != 0 || d % 2 != 0 && i % 2 == 0) {
						int a1 = (d - i + 1) / 2;
						int an = (d + i - 1) / 2;
						ArrayList<Integer> temp = new ArrayList<Integer>();
						for (int j = a1; j <= an; j++)
							temp.add(j);
						list.add(temp);
					}
				}
			}
			return list;
		}
	}
}
