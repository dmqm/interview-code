package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� һ�������� N ��Ԫ�أ�����������������͡� ���磺[-1,2,1]������������������Ϊ[2,1]�����Ϊ 3 ��������:
 * 
 * ����Ϊ���С� ��һ��һ������n(1 <= n <= 100000)����ʾһ����n��Ԫ�� �ڶ���Ϊn��������ÿ��Ԫ��,ÿ����������32λint��Χ�ڡ��Կո�ָ���
 * 
 * �������:
 * 
 * ���������������к�����ֵ��
 */
public class T29�������� {
	// �ȶ�̬�滮�򵥵ģ������ۼӣ�ֻҪС��0�����㣬���¿�ʼ��ֻ��Ҫ��¼�����е����ֵ
	public static class Main {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int[] arr = new int[n];
			int m = n, i = 0;
			while (m-- > 0) {
				arr[i++] = sc.nextInt();
			}
			int maxSoFar = Integer.MIN_VALUE, maxCur = 0;
			for (i = 0; i < n; i++) {
				maxCur = Math.max(maxCur + arr[i], arr[i]);
				maxSoFar = Math.max(maxCur, maxSoFar);
			}
			System.out.println(maxSoFar);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int[] src = new int[n];
			for (int i = 0; i < n; i++)
				src[i] = in.nextInt();
			long[] f = new long[n];
			f[0] = src[0];
			long max = f[0];
			for (int i = 1; i < n; i++) {
				if (f[i - 1] > 0)
					f[i] = src[i] + f[i - 1];
				else
					f[i] = src[i];
				if (f[i] > max)
					max = f[i];
			}
			System.out.println(max);
		}
	}

}
