package coding.nowcoder.old;
import java.util.Scanner;

// ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��13��˹�����6��,���Ƕ��ں�����������û���ˡ�ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�����
public class Test32 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(Solution.NumberOf1Between1AndN_Solution(n));
	}

	public static class Solution {
		public static int NumberOf1Between1AndN_Solution(int n) {
			int ans = 0, a, b;
			for (int i = 1; i <= n; i *= 10) {
				a = n / i;
				b = n % i;
				ans = ans + i * (a + 8) / 10 + (a % 10 == 1 ? 1 : 0) * (b + 1);
			}
			return ans;
		}
	}
}
