package coding.nowcoder;

/*
 * ��Ŀ���� �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ���������������һ���������ַ�����S���������ѭ������Kλ���������������磬�ַ�����S=��
 * abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
 */
public class T43����ת�ַ��� {
	public class Solution {
		public String LeftRotateString(String str, int n) {
			// ��֤��ת��λ�������ַ����ĳ��ȣ����򷵻ؿ��ַ���
			if (n > str.length())
				return "";
			// ��ԭ�ַ�����ȡ�����ַ�����Ȼ��ƴ��
			String s1 = str.substring(0, n);
			String s2 = str.substring(n, str.length());
			return s2 + s1;
		}
	}
}
