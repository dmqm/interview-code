package coding.nowcoder;

/*
 * ��Ŀ���� ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
public class T02�滻�ո� {

	public class Solution {
		public String replaceSpace(StringBuffer str) {
			StringBuilder sb = new StringBuilder();
			if (null == str)
				return sb.toString();
			int index = -1, nextIndex = -1;
			while ((nextIndex = str.indexOf(" ", index + 1)) != -1) {
				sb.append(str.substring(index + 1, nextIndex) + "%20");
				index = nextIndex;
			}
			sb.append(str.substring(index + 1));
			return sb.toString();
		}
	}
	public class Solution2 {
		public String replaceSpace(StringBuffer str) {
			if (str == null) {
				return null;
			}
			StringBuilder newStr = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ' ') {
					newStr.append('%');
					newStr.append('2');
					newStr.append('0');
				} else {
					newStr.append(str.charAt(i));
				}
			}
			return newStr.toString();
		}
	}
}
