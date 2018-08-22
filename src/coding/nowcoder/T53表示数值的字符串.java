package coding.nowcoder;

/*
 * ��Ŀ���� ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С���������磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
 * ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 */
public class T53��ʾ��ֵ���ַ��� {
	// ������ʽ�ⷨ
	public class Solution {
		public boolean isNumeric(char[] str) {
			String string = String.valueOf(str);
			return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
		}
	}
	/*
	 * ���¶�������н���: [\\+\\-]? -> ���򸺷��ų������ \\d* -> ���������Ƿ���֣���-.34 �� +3.34������ (\\.\\d+)? ->
	 * �������С���㣬��ôС���������������֣� ����һ�𲻳��� ([eE][\\+\\-]?\\d+)? -> �������ָ�����֣���ôe��E�϶����֣�+��-���Բ����֣�
	 * �����ű�����������������������ֶ�������
	 */

	// �μ���ָoffer
	public class Solution2 {
		private int index = 0;

		public boolean isNumeric(char[] str) {
			if (str.length < 1)
				return false;
			boolean flag = scanInteger(str);
			if (index < str.length && str[index] == '.') {
				index++;
				flag = scanUnsignedInteger(str) || flag;
			}
			if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
				index++;
				flag = flag && scanInteger(str);
			}
			return flag && index == str.length;
		}

		private boolean scanInteger(char[] str) {
			if (index < str.length && (str[index] == '+' || str[index] == '-'))
				index++;
			return scanUnsignedInteger(str);
		}

		private boolean scanUnsignedInteger(char[] str) {
			int start = index;
			while (index < str.length && str[index] >= '0' && str[index] <= '9')
				index++;
			return start < index; // �Ƿ��������
		}
	}
	public class Solution3 {
		public boolean isNumeric(char[] str) {
			boolean hasPoint = false;
			boolean hasEe = false;
			for (int i = 0; i < str.length; i++) {
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
				} else if (str[i] >= '0' && str[i] <= '9')
					continue;
				else
					return false;
			}
			return true;
		}
	}
}
