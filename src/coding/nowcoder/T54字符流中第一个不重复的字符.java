package coding.nowcoder;

/*
 * ��Ŀ���� ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"�����Ӹ��ַ����ж���ǰ�����ַ���
 * google"ʱ����һ��ֻ����һ�ε��ַ���"l"�� �������:
 * 
 * �����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���
 * 
 */
public class T54�ַ����е�һ�����ظ����ַ� {
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
