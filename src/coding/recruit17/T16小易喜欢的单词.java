package coding.recruit17;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * ��Ŀ���� С��ϲ���ĵ��ʾ����������ԣ� 1.����ÿ����ĸ���Ǵ�д��ĸ 2.����û��������ȵ���ĸ
 * 3.����û�����硰xyxy��(�����x��yָ�Ķ�����ĸ�����ҿ�����ͬ)�����������У������п��ܲ������� ���磺 С�ײ�ϲ��"ABBA"����Ϊ����������������'B'
 * С�ײ�ϲ��"THETXH"����Ϊ�������������"THTH" С�ײ�ϲ��"ABACADA"����Ϊ�������������"AAAA" С��ϲ��"A","ABA"��"ABCBA"��Щ����
 * ����һ�����ʣ���Ҫ�ش�С���Ƿ��ϲ��������ʡ� ��������:
 * 
 * ����Ϊһ���ַ��������ɴ�д��ĸ��ɣ�����С��100
 * 
 * �������:
 * 
 * ���С��ϲ�����"Likes",��ϲ�����"Dislikes"
 */
public class T16С��ϲ���ĵ��� {
	// ���˵ġ���
	public static class Main {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			while (sc.hasNext()) {
				String word = sc.next();

				if (isAllUpCase(word) && isConEql(word) && isThrEql(word))
					System.out.println("Likes");
				else
					System.out.println("Dislikes");
			}
		}

		// ����1
		public static boolean isAllUpCase(String word) {
			return word.matches("[A-Z]+");
		}

		// ����2
		public static boolean isConEql(String word) {
			return !word.matches(".*(.)(\\1).*");
		}

		// ����3
		public static boolean isThrEql(String word) {
			return !word.matches(".*(.).*(.)(.*\\1)(.*\\2).*");
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] src = in.nextLine().toCharArray();
		ArrayList<Character> list1 = new ArrayList<Character>();
		ArrayList<Character> list2 = new ArrayList<Character>();
		for (int i = 0; i < src.length; i++)
			if (src[i] < 'A' || src[i] > 'Z' || (i > 0 && src[i] == src[i - 1])) {
				System.out.println("Dislikes");
				return;
			} else {
				if (!list1.contains(src[i]))
					list1.add(src[i]);
				else if (!list2.contains(src[i]))
					list2.add(src[i]);
			}
		if (list2.size() >= 2) {
			for (int i = 0; i < list2.size(); i++)
				for (int j = i; j < list2.size(); j++) {
					char a = list2.get(i);
					char b = list2.get(j);
					StringBuilder sb = new StringBuilder();
					for (char k : src)
						if (k == 'a' || k == 'b')
							sb.append(k);
					String c = sb.toString();
					int index = 0;
					index = c.indexOf(a, index);
					index = c.indexOf(b, index);
					index = c.indexOf(a, index);
					index = c.indexOf(b, index);
					if (index != -1) {
						System.out.println("Dislikes");
						return;
					}
				}
		}
		System.out.println("Likes");
	}
}
