package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� �����Ĵ�����һ�������ͷ�����һ�����ַ��������硰level�����ߡ�noon���ȵȾ��ǻ��Ĵ��������ǳ�ϲ������ӵ�жԳ����Ļ��Ĵ������յ�ʱ�����õ���������ֱ����ַ���A���ַ���B��
 * �������ǳ�������û�а취���ַ���B�����ַ���Aʹ�������ַ�����һ�����Ĵ�������ܻ��������󣬰�����Ѱ���ж����ֲ���취����ʹ�´���һ�����Ĵ�������ַ���B�����λ�ò�ͬ�Ϳ���Ϊ��һ���İ취��
 * ���磺 A = ��aba����B = ��b����������4�ְ�B����A�İ취�� ��A�ĵ�һ����ĸ֮ǰ: "baba" ���ǻ��� �ڵ�һ����ĸ��a��֮��: "abba" �ǻ��� ����ĸ��b��֮��:
 * "abba" �ǻ��� �ڵڶ�����ĸ'a'֮�� "abab" ���ǻ��� �������������Ĵ�Ϊ2 ��������:
 * 
 * ÿ���������ݹ����С� ��һ��Ϊ�ַ���A �ڶ���Ϊ�ַ���B �ַ������Ⱦ�С��100��ֻ����Сд��ĸ
 * 
 * �������:
 * 
 * ���һ�����֣���ʾ���ַ���B�����ַ���A֮�󹹳�һ�����Ĵ��ķ�����
 */
public class T13ͳ�ƻ��� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String A = in.nextLine();
			String B = in.nextLine();
			int res = 0;
			for (int i = 0; i <= A.length(); i++) {
				StringBuilder des = new StringBuilder(A);
				if (isRequired(des.insert(i, B).toString().toCharArray()))
					res++;
			}
			System.out.println(res);
		}
	}

	public static boolean isRequired(char[] des) {
		int low = 0, high = des.length - 1;
		while (high > low) {
			if (des[high] != des[low])
				return false;
			high--;
			low++;
		}
		return true;

	}

}
