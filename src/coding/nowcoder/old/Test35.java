package coding.nowcoder.old;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

// ��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
public class Test35 {
	public class Solution {
		public int FirstNotRepeatingChar(String str) {
			LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
			for (int i = 0; i < str.length(); i++) {
				Character t = str.charAt(i);
				if (map.containsKey(t))
					map.put(t, map.get(t) + 1);
				else
					map.put(t, 1);
			}
			for (Entry<Character, Integer> entry : map.entrySet()) {
				if (entry.getValue() == 1)
					return str.indexOf(entry.getKey());
			}
			return -1;
		}
	}
}
