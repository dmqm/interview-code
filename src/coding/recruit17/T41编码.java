package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� �ٶ�һ�ֱ���ı��뷶Χ��a ~ y��25����ĸ����1λ��4λ�ı��룬������ǰѸñ��밴�ֵ��������γ�һ���������£� a, aa, aaa, aaaa, aaab, aaac, ��
 * ��, b, ba, baa, baaa, baab, baac �� ��, yyyw, yyyx, yyyy ����a��IndexΪ0��aa��IndexΪ1��aaa��IndexΪ2���Դ����ơ�
 * ��дһ������������������һ�����룬�����������Ӧ��Index. ��������:
 * 
 * ����һ����������ַ���,�ַ�������С�ڵ���100.
 * 
 * �������:
 * 
 * �����������index
 * 
 * ʾ��1 ���� ����
 * 
 * baca
 * 
 * ��� ����
 * 
 * 16331
 * 
 * 
 */
public class T41���� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] src = in.nextLine().toCharArray();
		int res = 0;
		int muti = 1;
		int[] sum = new int[4];
		sum[3] = 1;
		for (int i = 2; i >= 0; i--) {
			muti *= 25;
			sum[i] = sum[i + 1] + muti;
		}
		for (int i = 0; i < src.length; i++) {
			res += (src[i] - 'a') * sum[i] + 1;
		}
		System.out.println(res - 1);
	}

}
