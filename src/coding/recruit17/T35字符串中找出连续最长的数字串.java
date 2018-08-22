package coding.recruit17;


import java.util.Scanner;

/*
 * ��Ŀ���� ����һ���ַ���str������ַ���str�е�����������ִ� ��������:
 * 
 * �������������1������������һ���ַ���str�����Ȳ�����255��
 * 
 * �������:
 * 
 * ��һ�������str��������������ִ���
 * 
 * ʾ��1 ���� ����
 * 
 * abcd12345ed125ss123456789
 * 
 * ��� ����
 * 
 * 123456789
 * 
 */
public class T35�ַ������ҳ�����������ִ� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int max = 0, offset1 = 0;
		int now = 0, offset2 = 0;
		for (int i = 0; i < str.length(); i++) {
			char t = str.charAt(i);
			if (t >= '0' && t <= '9') {
				offset2++;
				if (offset2 > offset1) {
					max = now;
					offset1 = offset2;
				}
			} else {
				now = i + 1;
				offset2 = 0;
			}
		}
		System.out.println(str.substring(max, max + offset1));
	}

}
