package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� Fibonacci��������������ģ� F[0] = 0 F[1] = 1 for each i �� 2: F[i] = F[i-1] + F[i-2]
 * ��ˣ�Fibonacci���о����磺0, 1, 1, 2, 3, 5, 8, 13,
 * ...����Fibonacci�����е������ǳ�ΪFibonacci��������һ��N�����������Ϊһ��Fibonacci����ÿһ������԰ѵ�ǰ����X��ΪX-1����X+1��
 * ���ڸ���һ����N��������Ҫ���ٲ����Ա�ΪFibonacci���� ��������:
 * 
 * ����Ϊһ��������N(1 �� N �� 1,000,000)
 * 
 * �������:
 * 
 * ���һ����С�Ĳ�����ΪFibonacci��"
 */
public class T17Fibonacci���� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int f1 = 0, f2 = 1, f;
			while (f2 < N) {
				f = f2;
				f2 = f1 + f2;
				f1 = f;
			}
			System.out.println(Math.min(f2 - N, N - f1));
		}
	}

}
