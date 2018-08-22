package coding.recruit17;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * ��Ŀ���� С��������һ��ʯ��·ǰ��ÿ��ʯ���ϴ�1���ű��Ϊ��1��2��3....... ����ʯ��·Ҫ��������Ĺ������ǰ��������С�׵�ǰ���ڵı��ΪK��
 * ʯ�壬С�׵���ֻ����ǰ��K��һ��Լ��(����1��K)����������K+X(XΪK��һ����1�ͱ����Լ��)��λ�á�
 * С�׵�ǰ���ڱ��ΪN��ʯ�壬�����������ǡ��ΪM��ʯ��ȥ��С����֪��������Ҫ��Ծ���ο��Ե�� ���磺 N = 4��M = 24�� 4->6->8->12->18->24
 * ����С��������Ҫ��Ծ5�Σ��Ϳ��Դ�4��ʯ������24��ʯ�� ��������:
 * 
 * ����Ϊһ�У�����������N��M���Կո������ (4 �� N �� 100000) (N �� M �� 100000)
 * 
 * �������:
 * 
 * ���С��������Ҫ��Ծ�Ĳ���,������ܵ������-1
 */
public class T23��ʯ�� {
	// ���˵ķ�������̬�滮
	public static class Main {
		public static int deal(int m, int n) {// m��n
			int mark[] = new int[n + 1];// ��¼����ÿһ��λ�õĲ���
			for (int i = m + 1; i <= n; i++) { // ��ʼ��
				mark[i] = Integer.MAX_VALUE;
			}
			for (int i = m; i < n - 1; i++) { // ��mark[]
				if (mark[i] == Integer.MAX_VALUE)
					continue; // �����ǰ��ʼλ�ñ����ɴ� ��������
				ArrayList<Integer> list = allFactor(i); // ��õ�ǰλ��i����������
				for (int j = 0; j < list.size(); j++) { // ����i�ܵ����ÿһ��λ��tmp
					int tmp = i + list.get(j);
					int count = mark[i] + 1;
					if (tmp <= n && mark[tmp] > count) { // �����i����λ��tmp�Ĵ�������ǰ��¼��С ����mark[tmp]
						mark[tmp] = count;
					}
				}
			}
			return mark[n];
		}

		public static ArrayList<Integer> allFactor(int n) {// ���n���������� ��1 n��
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					list.add(i);
					if (i != n / i)
						list.add(n / i);
				}
			}
			return list;
		}

		public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);
			int m = sc.nextInt();
			int n = sc.nextInt();
			int r = deal(m, n);
			if (r == Integer.MAX_VALUE)
				r = -1;
			System.out.println(r);
		}
	}

	// ˼·������������,̰���㷨
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int M = in.nextInt();
			System.out.println(getDesHelper(N, M));;
		}
	}

	public static int getDesHelper(int n, int m) {
		if (m < n || getMaxDiv(n) == 1 || getMaxDiv(n, m) == 1)
			return -1;
		int res = 0;
		while (n != m) {
			if (n == getMaxDiv(n, m))
				n += getMaxDiv(n);
			else
				n += getMaxDiv(n, m);
			res++;
		}
		return res;
	}

	// Ĭ��m>n
	public static int getMaxDiv(int n, int m) {
		int t = m % n;
		while (t != 0) {
			m = n;
			n = t;
			t = m % n;
		}
		return n;
	}

	public static int getMaxDiv(int n) {
		for (int i = n - 1; i > 1; i--)
			if (n % i == 0)
				return i;
		return 1;
	}
}
