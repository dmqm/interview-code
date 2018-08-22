package coding.recruit17;

import java.util.Scanner;

/*
 * ��Ŀ���� ������n���ַ����ַ��������������ַ������ȶ��ǲ�ͬ�ġ��������ѧϰ���������ַ��������򷽷��� 1.�����ַ������ֵ����������磺 "car" < "carriage" < "cats"
 * < "doggies < "koala" 2.�����ַ����ĳ����������磺 "car" < "cats" < "koala" < "doggies" < "carriage"
 * ������֪���Լ�����Щ�ַ�������˳���Ƿ��������������򷽷�������Ҫæ�ų���Ҷ��������Ҫ������æ��֤�� ��������:
 * 
 * �����һ��Ϊ�ַ�������n(n �� 100) ��������n��,ÿ��һ���ַ���,�ַ������Ⱦ�С��100������Сд��ĸ���
 * 
 * �������:
 * 
 * �����Щ�ַ����Ǹ����ֵ������ж����Ǹ��ݳ����������"lexicographically",
 * 
 * ������ݳ������ж������ֵ����������"lengths",
 * 
 * ������ַ�ʽ���������"both"���������"none"
 */
public class T15�������򷽷� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		if (n <= 1) {
			System.out.println("both");
			return;
		}
		boolean lexicographically = true;
		boolean lengths = true;
		String[] array = new String[n];
		for (int i = 0; i < n; i++)
			array[i] = in.nextLine();
		for (int i = 1; i < n; i++)
			if (array[i - 1].compareTo(array[i]) >= 0) {
				lexicographically = false;
				break;
			}
		for (int i = 1; i < n; i++) {
			if (array[i - 1].length() >= array[i].length()) {
				lengths = false;
				break;
			}
		}
		if (lengths && lexicographically)
			System.out.println("both");
		else if (lengths)
			System.out.println("lengths");
		else if (lexicographically)
			System.out.println("lexicographically");
		else
			System.out.println("none");
	}
}
