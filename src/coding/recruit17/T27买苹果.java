package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� С��ȥ�������̵���ƻ������թ���̷�ʹ���������ף�ֻ�ṩ6��ÿ����8��ÿ���İ�װ(��װ���ɲ��)��
 * ����С������ֻ�빺��ǡ��n��ƻ����С���빺�����ٵĴ�������Я����������ܹ���ǡ��n��ƻ����С�׽����Ṻ�� ��������:
 * 
 * ����һ������n����ʾС���빺��n(1 �� n �� 100)��ƻ��
 * 
 * �������:
 * 
 * ���һ��������ʾ������Ҫ����Ĵ��������������ǡ��n��ƻ�������-1
 */
public class T27��ƻ�� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int res = 3 * (n / 24);
			n = n % 24;
			switch (n) {
				case 0:
					break;
				case 6:
				case 8:
					res += 1;
					break;
				case 12:
				case 14:
				case 16:
					res += 2;
					break;
				case 18:
				case 20:
				case 22:
					res += 3;
					break;
				default:
					res = -1;
			}
			System.out.println(res);
		}
	}

}
