package coding.nowcoder.old;
/*
 * ��Ŀ���� ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0 ��������:
 * 
 * ����һ���ַ���,����������ĸ����,����Ϊ��
 * 
 * �������:
 * 
 * ����ǺϷ�����ֵ����򷵻ظ����֣����򷵻�0
 * 
 * ʾ��1 ����
 * 
 * +2147483647 1a33
 * 
 * ���
 * 
 * 2147483647 0
 * 
 */
public class Test50 {
	public class Solution {
		public int StrToInt(String str) {
			int res = 0;
			int temp, i = 0, signal = 0;
			if (str.length() == 0)
				return 0;
			if (str.charAt(0) == '+') {
				i++;
				signal = 0;
			}
			if (str.charAt(0) == '-') {
				i++;
				signal = 1;
			}
			for (; i < str.length(); i++) {
				temp = str.charAt(i) - '0';
				if (temp <= 0 || temp > 9)
					return 0;
				res = 10 * res + temp;
			}
			return signal == 0 ? res : -res;
		}
	}
}
