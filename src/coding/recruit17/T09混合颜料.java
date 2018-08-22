package coding.recruit17;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ��Ŀ���� �����һ�����ң������������һ����������������û���㹻��ɫ�����ϡ�Ϊ��������򵥣���������������ʾ��ͬ��ɫ�����ϡ���֪���������Ҫ��n����ɫ�����ϣ������ڿ���ȥ�̵깺��һЩ���ϣ�
 * �����̵겻�ܱ�֤�ܹ�Ӧ������ɫ�����ϣ���������Ҫ�Լ����һЩ���ϡ�������ֲ�һ������ɫA����ɫB���Ͽ��Բ���(A XOR
 * B)������ɫ������(�²���������Ҳ��������������ϲ����µ���ɫ,XOR��ʾ������)�������ڼ��Լ�ľ������빺����ٵ����Ͼ�����Ҫ��
 * ���Լ�ְ����Ա������Ҫ����������������Ҫ��������ɫ�����ϣ� ��������:
 * 
 * ��һ��Ϊ�����������Ҫ����ɫ����n (1 �� n �� 50) �ڶ���Ϊn����xi(1 �� xi �� 1,000,000,000)����ʾ��Ҫ�ĸ�������.
 * 
 * �������:
 * 
 * ���������Ҫ���̵깺���������ɫ������ע����ܹ������ɫ��һ����ʹ���ڻ��У�ֻ��Ϊ�˲����µ���ɫ��
 */
public class T09������� {
	// �����ȣ������޹���
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			int[] col = new int[n];
			for (int i = 0; i < n; i++) {
				col[i] = scan.nextInt();
			}
			Arrays.sort(col);
			int count = 0;
			for (int i = n - 1; i >= 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					if (highbit(col[i]) == highbit(col[j])) {
						col[j] = col[j] ^ col[i];
					}
				}
				Arrays.sort(col);
			}
			for (int i = 0; i < n; i++)
				if (col[i] != 0) {
					count++;
				}
			System.out.println(count);
		}
	}

	// ���λ
	public static int highbit(int x) {
		for (int i = 31; i >= 0; i--) {
			int m = (x >> i) & 1;
			if (m != 0)
				return i + 1;
		}
		return 0;
	}
}
