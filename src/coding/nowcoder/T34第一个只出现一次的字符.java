package coding.nowcoder;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/*
 * 题目描述 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class T34第一个只出现一次的字符 {
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
