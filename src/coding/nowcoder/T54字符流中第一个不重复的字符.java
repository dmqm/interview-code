package coding.nowcoder;

/*
 * 题目描述 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“
 * google"时，第一个只出现一次的字符是"l"。 输出描述:
 * 
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * 
 */
public class T54字符流中第一个不重复的字符 {
	public class Solution {
		StringBuffer str = new StringBuffer();
		int[] signal = new int[256];

		public void Insert(char ch) {
			str.append(ch);
			if (signal[ch] == 0)
				signal[ch] = 1;
			else
				signal[ch] += 1;
		}

		public char FirstAppearingOnce() {
			char[] src = str.toString().toCharArray();
			for (char c : src)
				if (signal[c] == 1)
					return c;
			return '#';
		}
	}
}
