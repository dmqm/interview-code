package coding.nowcoder.old;
/*
 * ��Ŀ���� ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С���������磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
 * ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 */
public class Test54 {
	public class Solution {
		public boolean isNumeric(char[] str) {
			boolean hasPoint=false;
			boolean hasEe=false;
			for(int i=0;i<str.length;i++) {
				if (str[i] == '+' || str[i] == '-') {
					if (i == 0)
						continue;
					if ((str[i - 1] == 'E' || str[i - 1] == 'e') && i != str.length - 1)
						continue;
					else
						return false;
				} else if (str[i] == 'E' || str[i] == 'e') {
					if (!hasEe) {
						hasEe = true;
						if (i == str.length - 1)
							return false;
						continue;
					} else
						return false;
				} else if (str[i] == '.') {
					if (!hasPoint && !hasEe) {
						hasPoint = true;
					} else
						return false;
				}else if(str[i]>='0'&&str[i]<='9')
					continue;
				else
					return false;
			}
			return true;

		}
	}
}
