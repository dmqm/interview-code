package coding.nowcoder.old;


import java.util.Scanner;

// ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
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
