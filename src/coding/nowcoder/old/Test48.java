package coding.nowcoder.old;
/* ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C���� */
public class Test48 {
	public class Solution {
		public int Sum_Solution(int n) {
			int sum = n;
			boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
			return sum;
		}
	}
}
