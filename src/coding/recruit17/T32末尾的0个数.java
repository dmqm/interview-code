package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� ����һ��������n,��n!(���׳�)ĩβ�ж��ٸ�0�� ����: n = 10; n! = 3628800,���Դ�Ϊ2 ��������:
 * 
 * ����Ϊһ�У�n(1 �� n �� 1000)
 * 
 * �������:
 * 
 * ���һ������,����Ŀ����
 */
public class T32ĩβ��0���� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int res = 0, temp;
			for (int i = 1; i <= n; i++) {
				temp = i;
				while (temp % 5 == 0) {
					res++;
					temp /= 5;
				}
			}
			System.out.println(res);
		}
	}

	public static void others() {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int res = 0;
			while (n > 0) {
				n /= 5;
				res += n;
			}
			System.out.println(res);
		}
	}
}
