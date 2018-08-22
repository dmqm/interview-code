package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� ����һ������������д��������ж��ٶ������ĺ͵���������������������������������ֵС��1000�� �磬����Ϊ10,
 * ����Ӧ��������Ϊ2�����������������ĺ�Ϊ10,�ֱ�Ϊ(5,5),(3,7)�� ��������:
 * 
 * �������һ������n,(3 �� n < 1000)
 * 
 * �������:
 * 
 * �������
 * 
 * 
 * ʾ��1 ���� ����
 * 
 * 10
 * 
 * ��� ����
 * 
 * 2
 * 
 * 
 */
public class T43������ {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int res = 0;
		for (int i = 1; i <= n / 2; i++) {
			if (isPrime(i) && isPrime(n - i)) {
				res++;
				System.out.println(i + ":" + (n - i));
			}
		}
		System.out.println(res);
	}

	public static boolean isPrime(int src) {
		if (src == 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(src); i++) {
			if (src % i == 0) {
				return false;
			}
		}
		return true;
	}

}
