package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� ����һ��ʮ������M���Լ���Ҫת���Ľ�����N����ʮ������Mת��ΪN������ ��������:
 * 
 * ����Ϊһ�У�M(32λ����)��N(2 �� N �� 16)���Կո������
 * 
 * �������:
 * 
 * Ϊÿ������ʵ�����ת���������ÿ�����ռһ�С����N����9�����Ӧ�����ֹ���ο�16���ƣ����磬10��A��ʾ���ȵȣ�
 */
public class T33����ת�� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int M = in.nextInt();
			int N = in.nextInt();
			boolean flag = true;
			if (M < 0) {
				flag = false;
				M = -M;
			}
			StringBuilder sb = new StringBuilder();
			while (M != 0) {
				if (M % N > 9)
					sb.insert(0, (char) ('A' + M % N - 10));
				else
					sb.insert(0, M % N);
				M /= N;
			}
			if (!flag)
				sb.insert(0, '-');
			System.out.println(sb.toString());
		}
	}
}
