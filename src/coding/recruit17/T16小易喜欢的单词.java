package coding.recruit17;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 题目描述 小易喜欢的单词具有以下特性： 1.单词每个字母都是大写字母 2.单词没有连续相等的字母
 * 3.单词没有形如“xyxy”(这里的x，y指的都是字母，并且可以相同)这样的子序列，子序列可能不连续。 例如： 小易不喜欢"ABBA"，因为这里有两个连续的'B'
 * 小易不喜欢"THETXH"，因为这里包含子序列"THTH" 小易不喜欢"ABACADA"，因为这里包含子序列"AAAA" 小易喜欢"A","ABA"和"ABCBA"这些单词
 * 给你一个单词，你要回答小易是否会喜欢这个单词。 输入描述:
 * 
 * 输入为一个字符串，都由大写字母组成，长度小于100
 * 
 * 输出描述:
 * 
 * 如果小易喜欢输出"Likes",不喜欢输出"Dislikes"
 */
public class T16小易喜欢的单词 {
	// 别人的……
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

		// 条件1
		public static boolean isAllUpCase(String word) {
			return word.matches("[A-Z]+");
		}

		// 条件2
		public static boolean isConEql(String word) {
			return !word.matches(".*(.)(\\1).*");
		}

		// 条件3
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
