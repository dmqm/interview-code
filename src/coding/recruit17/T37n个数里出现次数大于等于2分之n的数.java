package coding.recruit17;


import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * ��Ŀ���� ����n��������������ִ������ڵ������鳤��һ������� ��������:
 * 
 * ÿ������������� n���ո�ָ��n��������n������100��������һ���������ִ������ڵ���n/2��
 * 
 * �������:
 * 
 * ������ִ������ڵ���n/2������
 * 
 * ʾ��1 ���� ����
 * 
 * 3 9 3 2 5 6 7 3 2 3 3 3
 * 
 * ��� ����
 * 
 * 3
 * 
 */
public class T37n��������ִ������ڵ���2��֮n���� {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] src = in.nextLine().split(" ");
		int length = src.length;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < length; i++) {
			if (map.containsKey(src[i])) {
				map.replace(src[i], map.get(src[i]) + 1);
			} else {
				map.put(src[i], 1);
			}
		}
		for (Entry<String, Integer> item : map.entrySet()) {
			if (item.getValue() >= length / 2 + length % 2) {
				System.out.println(item.getKey());
			}
		}
	}
}
