package coding.nowcoder;

/*
 * ��Ŀ���� ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0 ��������:
 * 
 * ����һ���ַ���,����������ĸ����,����Ϊ��
 * 
 * �������:
 * 
 * ����ǺϷ�����ֵ����򷵻ظ����֣����򷵻�0
 */
public class T49���ַ���ת�������� {
	public class Solution {
		public int StrToInt(String str) {
			int res = 0;
			int temp, i = 0;
			boolean signal = true;
			if (str.length() == 0)
				return 0;
			if (str.charAt(0) == '+') {
				i++;
			}
			if (str.charAt(0) == '-') {
				i++;
				signal = false;
			}
			for (; i < str.length(); i++) {
				temp = str.charAt(i) - '0';
				if (temp < 0 || temp > 9)
					return 0;
				res = res << 1 + res << 3 + temp;
			}
			return signal ? res : -res;
		}
	}
}
