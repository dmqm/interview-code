package coding.recruit17;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * ��Ŀ���� �ҳ�n��������С��k�� ��������:
 * 
 * ÿ��������������ո�ָ��n+1�����������һ������Ϊkֵ,n ������100��
 * 
 * �������:
 * 
 * ���n����������С��k�������������
 * 
 * ʾ��1 ���� ����
 * 
 * 3 9 6 8 -10 7 -11 19 30 12 23 5
 * 
 * ��� ����
 * 
 * -11 -10 3 6 7
 * 
 */
public class T36n��������С��k�� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String src = in.nextLine();
		String[] array = src.split(" ");
		int k = Integer.parseInt(array[array.length - 1]);
		array[array.length - 1] = String.valueOf(Integer.MAX_VALUE);
		Arrays.sort(array, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int s1 = Integer.parseInt(o1);
				int s2 = Integer.parseInt(o2);
				return s1 - s2;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			sb.append(array[i]).append(" ");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));
	}

}
