package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� n ֻ��ţ����һ�ţ�ÿ����ţӵ�� ai
 * ��ƻ����������Ҫ������֮��ת��ƻ����ʹ�����������ţӵ�е�ƻ��������ͬ��ÿһ�Σ���ֻ�ܴ�һֻ��ţ��������ǡ������ƻ������һ����ţ�ϣ���������Ҫ�ƶ����ٴο���ƽ��ƻ�������������������� -1��
 * ��������:
 * 
 * ÿ���������һ������������ÿ�����������ĵ�һ�а���һ������ n��1 <= n <= 100������������һ�а��� n ������ ai��1 <= ai <= 100����
 * 
 * �������:
 * 
 * ���һ�б�ʾ������Ҫ�ƶ����ٴο���ƽ��ƻ���������������������� -1��
 */
public class T05��ƻ�� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ai = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			ai[i] = in.nextInt();
			sum += ai[i];
		}
		int r = sum / n, s = sum % n;
		if (s != 0) {
			System.out.println(-1);
			return;
		}
		int t = r % 2;
		int count = 0;
		for (int i : ai) {
			if (i % 2 != t) {
				System.out.println(-1);
				return;
			}
			if (i > r)
				count += (i - r) / 2;
		}
		System.out.println(count);
	}

}
