package coding.nowcoder.old;
// �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ���������������һ���������ַ�����S���������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
public class Test44 {
	public class Solution {
		public String LeftRotateString(String str, int n) {
			int len = str.length();
			if (len == 0) {
				return "";
			}
			if (len < n) {
				n %= len;
			}
			String temp = str.substring(0, n);
			str = str.substring(n, len);
			str = str + temp;
			return str;
		}
	}
}
