package coding.nowcoder.old;

import java.util.ArrayList;
import java.util.Collections;

// 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
public class Test27 {
	// 各种……，回溯
	public class Solution {
		public ArrayList<String> Permutation(String str) {
			ArrayList<String> des = new ArrayList<String>();
			if (str != null && str.length() > 0)
				PermutationHelper(str.toCharArray(), 0, des);
			Collections.sort(des);
			return des;
		}

		private void PermutationHelper(char[] charArray, int i, ArrayList<String> des) {
			if (i == charArray.length - 1) {
				String val = String.valueOf(charArray);
				if (!des.contains(val))
					des.add(val);
			}
			for (int j = i; j < charArray.length; j++) {
				swap(charArray, i, j);
				PermutationHelper(charArray, i + 1, des);
				swap(charArray, i, j);
			}
		}

		private void swap(char[] charArray, int i, int j) {
			char t = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = t;
		}


	}
}
