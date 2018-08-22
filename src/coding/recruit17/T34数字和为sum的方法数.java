package coding.recruit17;


import java.util.Arrays;
import java.util.Scanner;

/*
 * ��Ŀ���� ����һ����n��������������A��һ������sum,��ѡ������A�в������ֺ�Ϊsum�ķ������� ������ѡȡ������һ�����ֵ��±겻һ��,���Ǿ���Ϊ�ǲ�ͬ����ɷ����� ��������:
 * 
 * ����Ϊ����: ��һ��Ϊ����������n(1 �� n �� 1000)��sum(1 �� sum �� 1000) �ڶ���Ϊn��������A[i](32λ����)���Կո������
 * 
 * �������:
 * 
 * �������ķ�����
 */
public class T34���ֺ�Ϊsum�ķ����� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int sum = in.nextInt();
			int[] A = new int[n];
			for (int i = 0; i < n; i++) {
				A[i] = in.nextInt();
			}
			int res = 0;
			Arrays.sort(A);
			// 2^n��������
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			int sum = in.nextInt();
			int[] value = new int[n];
			long[] dp = new long[sum + 1];
			dp[0] = 1;
			for (int i = 0; i < n; i++) {
				value[i] = in.nextInt();
				for (int j = sum; j >= 0; j--) {
					if (j >= value[i]) {
						dp[j] += dp[j - value[i]];
					}
				}
			}
			System.out.println(dp[sum]);
		}
	}
}
