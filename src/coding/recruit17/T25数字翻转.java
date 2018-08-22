package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� ����һ������X���������rev(X)Ϊ��X����λ��ת����������ȥ����ǰ��0������: ��� X = 123����rev(X) = 321; ��� X = 100����rev(X) = 1.
 * ���ڸ�������x��y,Ҫ��rev(rev(x) + rev(y))Ϊ���٣� ��������:
 * 
 * ����Ϊһ�У�x��y(1 �� x��y �� 1000)���Կո������
 * 
 * �������:
 * 
 * ���rev(rev(x) + rev(y))��ֵ
 */
public class T25���ַ�ת {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int x = in.nextInt(), y = in.nextInt();
			System.out.println(rev(rev(x) + rev(y)));
		}
	}

	public static int rev(int t) {
		StringBuilder sb = new StringBuilder();
		sb.append(t);
		sb.reverse();
		return Integer.parseInt(sb.toString());
	}


	public static int rev2(int num) {
		int x = 0;
		while (num != 0) {
			x = 10 * x + num % 10;
			num = num / 10;
		}
		return x;
	}
}
