package coding.recruit17;

import java.util.HashSet;
import java.util.Scanner;

/*
 * ��Ŀ���� ţţ�볢��һЩ�µ�����ÿ��������ҪһЩ��ͬ�Ĳ��ϣ���������е�������Ҫ׼�������ֲ�ͬ�Ĳ��ϡ� ��������:
 * 
 * ÿ��������� 1 ������������ÿ�����������ĵ� i �У���ʾ��ɵ� i ��������Ҫ��Щ���ϣ����������ÿո����������ֻ������дӢ����ĸ�Ϳո������ļ������� 50 �У�ÿһ�в����� 50
 * ���ַ���
 * 
 * �������:
 * 
 * ���һ��һ�����ֱ�ʾ�������������Ҫ�����ֲ�ͬ�Ĳ��ϡ�
 */
public class T03�³��� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashSet<String> set = new HashSet<String>();
		while (in.hasNext()) {
			String temp = in.next();
			set.add(temp);
		}
		System.out.println(set.size());;
	}

}
