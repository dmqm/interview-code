package coding.recruit17;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * ��Ŀ���� С��ͬѧ��1��n��n�����ְ���һ����˳�������һ������Q�С��������Զ���Qִ�������³���
 * 
 * while(!Q.empty()) //���в��գ�ִ��ѭ��
 * 
 * {
 * 
 * int x=Q.front(); //ȡ����ǰ��ͷ��ֵx
 * 
 * Q.pop(); //������ǰ��ͷ
 * 
 * Q.push(x); //��x�����β
 * 
 * x = Q.front(); //ȡ����ʱ���ͷ��ֵ
 * 
 * printf("%d\n",x); //���x
 * 
 * Q.pop(); //������ʱ��Ķ�ͷ
 * 
 * }
 * 
 * ��ȡ����ͷ��ֵ������ʱ�򣬲���������ǰ��ͷ��
 * С��ͬѧ���֣���γ���ǡ�ð�˳�������1,2,3,...,n������С�������㹹���ԭʼ�Ķ��У�����������[ע��ԭ������������5�д�Ӧ��Ϊ3������������] ��������:
 * 
 * ��һ��һ������T��T �� 100����ʾ����������ÿ����������һ����n��1 �� n �� 100000�������������n֮�Ͳ�����200000��
 * 
 * �������:
 * 
 * ����ÿ�����ݣ����һ�У���ʾԭʼ�Ķ��С�����֮����һ���ո��������Ҫ����ĩ�������Ŀո�.
 */
public class T20������� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int T = in.nextInt();
			int[] src = new int[T];
			for (int i = 0; i < T; i++)
				src[i] = in.nextInt();
		}
	}

	// ���˵ķ�������
	/*
	 * ˼�룺��ʹ��һ��1��n������ģ��С���Ĳ����� Ȼ���õ�һ����������磺3,5,10,7.... ��������Ӧ����� 1,2,3,4.... ���������ǾͿ��Է��Ƴ� 1Ӧ���ڵ�3��λ��
	 * 2Ӧ���ڵ�5��λ�� 3Ӧ���ڵ�10��λ�� 4Ӧ���ڵ�7��λ��
	 */
	public static class Main {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			int number = scanner.nextInt();
			while (number-- > 0) {
				int n = scanner.nextInt();
				helper(n);
			}
		}

		public static void helper(int n) {
			// ����һ��1-n������
			LinkedList<Integer> original = new LinkedList<Integer>();
			for (int i = 1; i <= n; i++) {
				original.addLast(i);
			}

			// ģ�����
			LinkedList<Integer> res = new LinkedList<Integer>();
			while (!original.isEmpty()) {
				int x = original.removeFirst();
				original.addLast(x);
				x = original.removeFirst();
				res.addLast(x);
			}

			// ���Ƴ���ȷλ�ã�����out������
			int[] out = new int[n];
			for (int i = 1; i <= n; i++) {
				int x = res.removeFirst();
				out[x - 1] = i;
			}

			// ���out����
			System.out.print(out[0]);
			for (int i = 1; i < n; i++) {
				System.out.print(" " + out[i]);
			}
			System.out.println();
		}
	}

}
