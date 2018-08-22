package coding.nowcoder.old;


import java.util.Scanner;

// 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class Test02 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	}
	public class Solution {
		public String replaceSpace(StringBuffer str) {
			int index = -1, old = -1;
			StringBuffer res = null;
			while ((index = str.indexOf(" ", index + 1)) != -1) {
				res = res.append(str.substring(old + 1, index) + "%20");
				old = index;
			}
			return res.append(str.substring(old + 1, str.length())).toString();

		}
	}
}
