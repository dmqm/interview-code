package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� С����һ�����۰����ߣ����Ҷ���һ����������Լ��ʮ�ָ���Ȥ��һ��С����������һ�����⣺ ���庯��f(x)Ϊx��������Լ����xΪ�������� ����:f(44) = 11.
 * ���ڸ���һ��N����Ҫ��� f(1) + f(2) + f(3).......f(N) ���磺 N = 7 f(1) + f(2) + f(3) + f(4) + f(5) + f(6) +
 * f(7) = 1 + 1 + 3 + 1 + 5 + 3 + 7 = 21 С�׼�������������������ѣ���Ҫ�������һ���㷨�������� ��������:
 * 
 * ����һ������N (1 �� N �� 1000000000)
 * 
 * �������:
 * 
 * ���һ����������Ϊf(1) + f(2) + f(3).......f(N)
 */
public class T26������Լ�� {
	/*
	 * ���˵�
	 * 
	 * ����˼·�� ��Ϊ�������������Լ�������Լ���������ż������ֻ��һֱ��2ֱ���õ�һ��������Ϊ�������Լ��
	 * 
	 * ����1 2 3 4 5 6 7 8 9 10 ��n=10 ����ʱ������1 3 5 7 9 ���ǰ��⼸���������Ȼ��n/2 �õ��ڶ����������� 1 2 3 4 5 �ֱ��Ӧ�ϴε�2 4 6
	 * 8 10 ���ż�������������ټ�1 3 5 ��������
	 * 
	 * ϸ�����⣺ ��nΪż��������n/2�����������ݵȲ�������͹�ʽ ��(������+ĩ�*����)/2,����֪��n/2��������Ϊ((1+n-1)*n/2)/2, ��Ϊ(n/2) *
	 * (n/2),��ʱnΪż������� (n/2) * (n/2) = ((n+1)/2) * ((n+1)/2)
	 * 
	 * ��nΪ��������(n+1)/2����������ʱ������Ϊ((n+1)/2) * ((n+1)/2) ����������������һ����ʽ���ܽ�
	 */
	public static class Main {
		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			long num = s.nextInt();
			long sum = 0;
			for (long i = num; i > 0; i = i / 2) {
				long temp = (i + 1) / 2;
				sum += temp * temp;
			}
			System.out.println(sum);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int res = 0;
			for (int i = 1; i <= N; i++)
				res += maxOldDiv(i);
			System.out.println(res);
		}
	}

	// Ϊʲô�⻹�ᳬʱ?
	public static int maxOldDiv(int t) {
		if ((t & 1) == 1)
			return t;
		else
			while ((t & 1) == 0)
				t >>= 1;
		return t;
	}
}
