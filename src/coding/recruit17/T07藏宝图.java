package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� ţţ�õ���һ���ر�ͼ��˳�Ųر�ͼ��ָʾ��ţţ������һ���ر��У��ر�������һ�����أ�����ÿ�λ���ʾ�����ַ��� s �� t�����ݹ��ϵĴ�˵��ţţ��Ҫÿ�ζ��ش� t �Ƿ��� s
 * �������С�ע�⣬�����в�Ҫ����ԭ�ַ������������ģ����紮 abc�����������о��� {�մ�, a, b, c, ab, ac, bc, abc} 8 �֡� ��������:
 * 
 * ÿ���������һ������������ÿ�����������������г��Ȳ����� 10 �Ĳ������ո�Ŀɼ� ASCII �ַ�����
 * 
 * �������:
 * 
 * ���һ�� ��Yes�� ���� ��No�� ��ʾ�����
 */
public class T07�ر�ͼ {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] count = new int[128];
		char[] sc = in.nextLine().toCharArray();
		char[] tc = in.nextLine().toCharArray();
		for (int i : count)
			count[i] = 0;
		for (char i : sc)
			count[i]++;
		for (char i : tc) {
			count[i]--;
			if (count[i] < 0) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}

}
